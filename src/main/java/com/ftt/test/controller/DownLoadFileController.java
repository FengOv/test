package com.ftt.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownLoadFileController {

    @RequestMapping ("/toDownLoad")
    public String toDownLoadFile(){
        return "downLoad";
    }
}
