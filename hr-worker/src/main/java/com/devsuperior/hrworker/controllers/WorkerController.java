package com.devsuperior.hrworker.controllers;


import com.devsuperior.hrworker.model.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> listAll(){
        return new ResponseEntity<>(workerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> listById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).get();
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

}
