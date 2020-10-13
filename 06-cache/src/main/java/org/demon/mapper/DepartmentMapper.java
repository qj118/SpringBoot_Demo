package org.demon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.demon.entity.Department;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department findDeptById(Integer id);
}
