package com.ftt.test;

import com.ftt.test.util.MathUtil;
import com.ftt.test.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MathUtil mathUtil;

    @Test
    void contextLoads() {
    }

    @Test
    public void remove(){
        int[] nums = {1,2,3,4,5,5,6,5};
        int val = 5;
        int numsLength = nums.length;
        for (int i = 0;i<numsLength;i++){
            if(nums[i]!=val){
                --numsLength;
            }
        }
        System.out.println(numsLength);
    }

    @Test
    @SuppressWarnings("all")
    public void merge(){
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        int m = 3;
        int[] nums2 = {2,3,7};
        int n = 3;
        //Arrays.sort(nums1);
        for (int i = 0;i!= n;++i){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    @Test
    public void rand(){
        //int[][] num = new int[9][];
        for (int i = 0; i < 9; i++ ) {

            for(int j = 0;j <= i;j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    @Test
    @SuppressWarnings("all")
    public void lengXing(){
        for(int i = 0;i < 9;i++){
            for(int j = i;j < 9 ;j++){
                /*if(){

                }*/
                System.out.println(" ");
            }
        }
    }

    @Test
    public void testRedis() throws InterruptedException {
        boolean code = mathUtil.create6Code("17635837270");
        System.out.println(redisUtil.get("17635837270"));
    }

}
