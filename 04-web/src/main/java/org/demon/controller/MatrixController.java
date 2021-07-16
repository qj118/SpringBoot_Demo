package org.demon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Demon
 * create on 2021/7/16-15:44
 */
@RestController
public class MatrixController {

    // 请求 /book;name=xxx;author=xxx
    @GetMapping("/{path}")
    public Map<String, Object> getBook(@MatrixVariable("name") String name,
                                       @MatrixVariable("author") String author,
                                       @PathVariable("path") String path){

        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("author", author);
        result.put("path", path); // book

        return result;
    }

    // 多层矩阵参数请求 /boss/1;age=35/2;age=23
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){
        Map<String, Object> result = new HashMap<>();

        result.put("bossAge", bossAge);
        result.put("empAge", empAge);

        return result;
    }
}
