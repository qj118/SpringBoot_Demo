package org.demon.controller;

import org.demon.dao.EmployeeDao;
import org.demon.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;

    // 如: http://localhost:8080/emp/1
    @GetMapping("/emp/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        Employee employee = employeeDao.findById(id);
        return employee;
    }

    // 如：http://localhost:8080/emp
    // 在 body 中的 form-data 中设置，如果采用 json 的话，需要使用 @RequestBody 注解
    @PostMapping("/emp")
    public Employee addEmp(Employee employee){
        employeeDao.addEmp(employee);
        return employee;
    }
}
