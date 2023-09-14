package com.ftt.test.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class MathUtil {

    @Autowired
    RedisUtil redisUtil;

    public static String get6Code(int n){
        Random r = new Random();
        String code = "";
        for (int i = 0; i < n; i++) {
            int type = r.nextInt(3);  // 0  1  2
            switch (type) {
                case 0:
                    // 大写英文 A 65  Z 90
                    char ch = (char) (r.nextInt(25) + 65);
                    code += ch;
                    break;
                case 1:
                    // 小写英文 A 97 Z 122
                    char ch1 = (char) (r.nextInt(25) + 97);
                    code += ch1;
                    break;
                case 2:
                    // 数字
                    int ch2 = r.nextInt(10);
                    code += ch2;
                    break;
            }
        }
        return code;
    }

    /**
     * 生成一个时长为60秒的六位验证码（区分大小写）
     * return : boolean
     */
    public boolean create6Code(String phoneNum){
        boolean b = false;
        try {
            redisUtil.set(phoneNum, MathUtil.get6Code(6),60);
            b = true;
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            b = false;
        }
        return b;
    }

}
