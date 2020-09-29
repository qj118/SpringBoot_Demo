package org.demon.controller;

import org.demon.entity.Employee;
import org.demon.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return service.findEmpById(id);
    }

    @PutMapping("/emp")
    public Employee updateEmp(Employee emp)
    {
        return service.updateEmp(emp);
    }

    @PostMapping("/emp")
    public Employee addEmp(Employee emp){
        return service.addEmp(emp);
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        service.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{name}")
    public Employee getEmpByName(@PathVariable("name") String name){
        return service.findEmpByName(name);
    }
}
