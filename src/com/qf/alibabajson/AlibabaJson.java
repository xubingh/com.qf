package com.qf.alibabajson;

import com.alibaba.fastjson.JSON;
import com.qf.jsondemo.User;
import com.qf.jsondemo.Word;
import org.junit.Test;

import java.util.List;

/**
 * 阿里巴巴json json字符串转成对象
 */
public class AlibabaJson {
    /**
     * 将字符串解析成对象
     * 简单形式
     */
    @Test
    public void test(){
        String json="{name:'小马哥',age:25}";
        User user = JSON.parseObject(json, User.class);
        System.out.println("字符串解析成对象"+user);
    }

    /**
     * 复杂形式形式转成对象
     */
    @Test
    public void test1(){
        //对象里面嵌套了对象
        String json="{name:'小明',age:3,word:{english:55,maths:65}}";
        User user = JSON.parseObject(json, User.class);
        System.out.println(user);
    }

    /**
     * 数组形式转成对象
     */
    @Test
    public void test2(){
        String json = "[{english:55,maths:88},{english:58,maths:78}]";
        List<Word> words = JSON.parseArray(json, Word.class);
        for (Word word : words) {
            System.out.println(word);
        }
    }
}
