package com.saras.paytm.controller;

import com.saras.paytm.entity.PaytmUser;
import com.saras.paytm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public String ping(){
        return "Hello World";
    }

    @PostMapping(value="/user")
    @ResponseStatus(HttpStatus.CREATED)
    public PaytmUser addUser(@RequestBody PaytmUser paytmUser){
        return userService.addUser(paytmUser);
    }

}
