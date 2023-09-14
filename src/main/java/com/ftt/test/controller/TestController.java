package com.ftt.test.controller;

import com.ftt.test.entity.Test;
import com.ftt.test.service.TestService;
import com.ftt.test.util.ImgCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Test test){
        String s = testService.addOneRow(test.getUserName(),test.getPassWord());
        if(s.startsWith("新增失败!")){
            return "error";
        }
        return "success";
    }

    @GetMapping("/getCode")
    public void code(HttpServletRequest request,
                     HttpServletResponse response){
        ImgCode.getCode(request,response);
    }

    @GetMapping("/getName/{id}")
    public String getNameById(@PathVariable Integer id){
        return testService.getNameById(id);
    }
}
