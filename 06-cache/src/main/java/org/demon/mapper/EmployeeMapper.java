package org.demon.mapper;

import org.apache.ibatis.annotations.*;
import org.demon.entity.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee findEmpById(Integer id);

    @Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    void updateEmp(Employee emp);

    @Delete("delete from employee where id = #{id}")
    void deleteEmp(Integer id);

    @Insert("insert into employee(lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    void addEmp(Employee emp);

    @Select("select * from employee where lastName = #{name}")
    Employee findEmpByName(String name);
}
