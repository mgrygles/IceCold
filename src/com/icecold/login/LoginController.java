package com.icecold.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the login process and submits to the back-end Login Service.
 *
 * TODO: currently the password is in cleartext, it will be encrypted in PROD.
 * 
 */
@RestController
public class LoginController {

    @RequestMapping("/icecold/login")
    public String login(@RequestParam(value="user_id") String userId, 
                        @RequestParam(value="thePassword") String passwd) {
        String message = "Unable to login";
        if (

        if (null != userId && !(userId.isEmpty())) {
            String message = new String("Welcome to IceCold, " + user_id + "!");
        } 
            
        return message;
    }
}    


