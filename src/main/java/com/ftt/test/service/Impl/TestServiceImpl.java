package com.ftt.test.service.Impl;

import com.ftt.test.dao.TestMapper;
import com.ftt.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    TestMapper testMapper;

    @Override
    public String addOneRow(String name, String pwd) {
        String message = "";
        try {
            Integer integer = testMapper.addOneRow(name,pwd);
            if(integer != 1){
                message = "新增失败!";
            }else
                message = "新增成功";
        }catch (Exception e){
            message = "新增失败!";
        }
        return message;
    }

    @Override
    public String getNameById(Integer id) {
        if(id == 1){
            return "ftt";
        }else{
            return "zkj";
        }
    }


}
