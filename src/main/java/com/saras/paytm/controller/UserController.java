package com.saras.paytm.controller;

import com.saras.paytm.entity.Users;
import com.saras.paytm.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping(value="/")
    public String ping(){
        return "Hello World";
    }

    @PostMapping(value="/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users paytmUser){
        return userDetailsServiceImpl.addUser(paytmUser);
    }

}
