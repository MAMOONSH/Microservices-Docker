package com.microservices.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class authentication {
    @Autowired
    private UserDaoService userService;
    @PostMapping(path = "/user")
    public Boolean isAuthenticated(@RequestBody User user) {
        return userService.checkIfValidUser(user);
    }
}
