package com.hackduck.sca.controller;

import com.hackduck.sca.model.User;
import com.hackduck.sca.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
public class AccessController {

 final
 UserRepository userRepository;

    public AccessController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/access")
    public Boolean access(@RequestParam(value="id") String id)
    {
     User user = userRepository.findByIduser(UUID.fromString(id));

     try {
         if (user.getStatus()==1)
             user.setStatus(0);
         else
             user.setStatus(1);
         userRepository.save(user);
         return true;
     }
     catch (NullPointerException ex)
     {
         return false;
     }
    }
}
