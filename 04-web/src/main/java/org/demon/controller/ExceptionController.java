package org.demon.controller;

import org.demon.exception.UserNotExistException;
import org.demon.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception(@RequestParam("user") String username){
        if(username.equals("demon")){
            throw new UserNotExistException();
        }
        return "redirect:/emps";
    }

    @RequestMapping("/twoUser")
    public String twoUser(){
        if(true){
            throw  new UserTooManyException();
        }
        return "redirect:/emps";
    }
}
