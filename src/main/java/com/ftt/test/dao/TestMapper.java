package com.ftt.test.dao;

import com.ftt.test.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

    //新增
    public Integer addOneRow(@Param("userName")String name,@Param("passWord")String pwd);

}
