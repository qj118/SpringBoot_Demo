package org.demon.service;

import org.demon.entity.Employee;
import org.demon.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"emp"}) // 抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper mapper;

    // 将方法返回的结果缓存，value 指定缓存组件名称
    @Cacheable(value = {"emp"})
    // @Cacheable(value = {"emp"}, key = "#root.methodName + '[' + #a0 + ']'") // findEmpById[id] 作为 key
    // @Cacheable(value = {"emp"}, keyGenerator = "myKeyGenerator", condition = "#a0 > 1", unless = "#a0 == 2")
    public Employee findEmpById(Integer id){
        System.out.println("findEmpById: " + id);
        return mapper.findEmpById(id);
    }

    /**
     * 先运行方法再更新缓存
     * 如果想要缓存更新后，查询的结果依然有效，需要保证更新缓存的 key 值与查询缓存的 key 值一致
     */
    @CachePut(value = {"emp"}, key = "#emp.id")
    public Employee updateEmp(Employee emp){
        System.out.println("updateEmp: " + emp);
        mapper.updateEmp(emp);
        return emp;
    }

    public Employee addEmp(Employee emp){
        System.out.println("addEmp: " + emp);
        mapper.addEmp(emp);
        return emp;
    }

    /**
     * 清除缓存
     * - 默认在方法执行之后执行，可以通过属性 beforeInvocation 来修改执行顺序
     * - allEntries 属性可以清楚缓存组里所有缓存
     */
    @CacheEvict(value = {"emp"}, key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp: " + id);
        //mapper.deleteEmp(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "#name")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public Employee findEmpByName(String name){
        System.out.println("getEmpByName: " + name);
        return mapper.findEmpByName(name);
    }
}
