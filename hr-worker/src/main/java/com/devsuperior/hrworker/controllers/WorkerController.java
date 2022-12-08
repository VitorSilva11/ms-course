package com.devsuperior.hrworker.controllers;


import com.devsuperior.hrworker.model.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(Worker.class);

    @Value("${test.config}")
    private String testConfig;

    private final Environment env;

    private final WorkerRepository workerRepository;

    public WorkerController(Environment env, WorkerRepository workerRepository) {
        this.env = env;
        this.workerRepository = workerRepository;
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> listAllConfig(){
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> listAll(){
        return new ResponseEntity<>(workerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> listById(@PathVariable Long id){

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id).get();
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

}