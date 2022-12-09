package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feignclients.UserFeignClient;
import com.devsuperior.hroauth.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;


    public User findByEmail(String email){

        User user = userFeignClient.findByEmail(email).getBody();

        logger.info("Email Found: " + email);

        return user;
    }

}
