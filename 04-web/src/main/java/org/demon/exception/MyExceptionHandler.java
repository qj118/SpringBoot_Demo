package org.demon.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice 是 Controller 增强器，
 * 作用是给 Controller 添加统一的操作或处理。
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 定制 json 数据
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception ex){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.not_exist");
        map.put("message", "用户出错了！");
        return map;
    }*/

    /**
     * 只需要请求转发到 /error, BasicErrorController 就会自动处理。
     * @param e
     * @param request 设置错误代码
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.not_exist");
        map.put("message", "用户出错了！");
        // 放到 request 域中
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}
