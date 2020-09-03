package com.rock.controller;

import com.rock.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

//注意不能使用@RestController，这里需要跳转到页面而不是返回一个json
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWord(@RequestParam("user") String user) {
        if ("login".equals(user)){
            throw new  UserNotExistException();
        }
        return "Hello Word";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>你好啊</h1>");
        map.put("names", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
