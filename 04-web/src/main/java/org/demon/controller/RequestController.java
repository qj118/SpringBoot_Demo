package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Demon
 * create on 2021/7/16-14:05
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        // 请求转发到其他界面
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg, @RequestAttribute("code") Integer code, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        result.put("msg", msg);
        result.put("code", code);

        //也可以从 ServletRequest 中获得
        result.put("request_msg", request.getAttribute("msg"));
        result.put("request_code", request.getAttribute("code"));
        return result;
    }
}
