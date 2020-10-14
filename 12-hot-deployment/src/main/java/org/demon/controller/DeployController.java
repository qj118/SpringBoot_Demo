package org.demon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeployController {

    @GetMapping("/")
    public String deploy(){
        return "部署成功！";
    }
}
