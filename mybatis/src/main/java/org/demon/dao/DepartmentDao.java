package org.demon.dao;

import org.apache.ibatis.annotations.*;
import org.demon.entity.Department;

//@Mapper
public interface DepartmentDao {

    @Select("select * from department where id = #{id}")
    Department findById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 让自动生成的 id 绑定到对象
    @Insert("insert into department(department_name) values(#{departmentName})")
    int addDept(Department dept);

    @Delete("delete from department where id = #{id}")
    int deleteDept(Integer id);

    @Update("update department set department_name = #{department_Name} where id = #{id}")
    int updateDept(Department dept);
}
