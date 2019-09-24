package com.qf.alibabajson;

import com.alibaba.fastjson.JSON;
import com.qf.jsondemo.Word;
import org.junit.Test;

import java.util.ArrayList;

/**
 *java对象转成Json字符串
 */
public class AlibabaJson2 {
    @Test
    public void test(){
        //简单的对象转成字符串
        Word word = new Word(55, 85);
        String str = JSON.toJSONString(word);
        System.out.println("java对象转成字符串"+str);
    }



    @Test
    public void test2(){
        //将集合转成json字符串
        ArrayList<Word> list = new ArrayList<>();
        Word word = new Word(12, 48);
        Word word1 = new Word(88, 55.4);
        list.add(word);
        list.add(word1);
        String str1 = JSON.toJSONString(list);
        System.out.println("集合转成json字符串"+str1);
    }
}
