package com.hackduck.sca;

import com.hackduck.sca.model.User;
import com.hackduck.sca.repository.UserRepository;
import com.hackduck.sca.service.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String []args){

        SpringApplication.run(Application.class,args);


        
    }
}
