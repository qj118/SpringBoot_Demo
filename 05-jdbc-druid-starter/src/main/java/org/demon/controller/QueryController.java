package org.demon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public JSONArray getDepartments(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");

        return JSONArray.parseArray(JSON.toJSONString(maps));
    }
}
