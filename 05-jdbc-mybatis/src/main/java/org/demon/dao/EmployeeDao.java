package org.demon.dao;

import org.demon.entity.Employee;

//@Mapper
public interface EmployeeDao {

    Employee findById(Integer id);

    void addEmp(Employee emp);
}
