package org.demon.controller;

import org.demon.dao.DepartmentDao;
import org.demon.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/dept/{id}")
    public Department getById(@PathVariable("id")Integer id){
        Department department = departmentDao.findById(id);
        return department;
    }

    @GetMapping("/dept")
    public Department addDept(Department department){
        departmentDao.addDept(department);
        return department;
    }
}
