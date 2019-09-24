package com.qf.jsondemo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

/**
 * java对象转成json字符串
 * 使用toString方法
 * jsonlib解析器
 */
public class UserTest2 {
    @Test
    public void test(){
        //简单对象转成接送字符串
        User user = new User();
        user.setName("小明");
        user.setAge(25);
        //将对象转成json字符串
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("对象转成json字符串"+jsonObject.toString());
    }
    /**
     *复杂的对象,里面有嵌套对象
     */
    @Test
    public void test2(){
        Word word = new Word(55, 67.6);
        //2.复杂的对象
        User user = new User("小红", 22, word);
        JSONObject object = new JSONObject(user);
        System.out.println(object.toString());
    }
    /**
     * 将集合转成json字符串
     */
    public void test3(){
        //实例化集合
        ArrayList<Word> list = new ArrayList<>();
        //实例化对象
        Word word = new Word(78.5, 65.3);
        Word word1 = new Word(65.5, 45.5);
        //把对象添加到集合里面
        list.add(word);
        list.add(word1);
        //实例化json对象,调用方法
        JSONArray jsonArray = new JSONArray(list);
        System.out.println(jsonArray.toString());
    }
}
