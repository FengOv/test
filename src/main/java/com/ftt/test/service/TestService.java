package com.ftt.test.service;

import com.ftt.test.entity.Test;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

public interface TestService {
    //
    public String addOneRow(String name, String pwd);

    public String getNameById(Integer id);
}
