package com.qf.jsondemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

/**
 * json 字符串转成java对象
 */
public class UserTest {


    @Test
    public  void Test1() throws JSONException {
        String json ="{name:'小明',age:12}";
        JSONObject jsono = new JSONObject(json);
        String name = jsono.getString("name");
        int age = jsono.getInt("age");
        System.out.println(name);
        System.out.println(age);
    }
    /**
     * 解析对象里面嵌套对象的json字符串
     */
    @Test
    public void test2() throws JSONException {
        String json = "{name:'张三',age:23,word:{english:88,maths:66}}";
        //解析为json对象
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        int age = object.getInt("age");
        JSONObject word = object.getJSONObject("word");
        double english = word.getDouble("english");
        double maths = word.getDouble("maths");
        //封装为word对象
        Word word1 = new Word(english, maths);
        //封装为user对象
        User user = new User(name, age, word1);
        System.out.println(user);
    }
    /**
     * 解析数组形式的json格式
     */
    @Test
    public void test3() throws JSONException {
        String json = "[{english:23,maths:34},{english:45,maths:66}]";
        //解析成jsonArraylist对象
        JSONArray array = new JSONArray(json);
        //定义一个集合
        ArrayList<Word> list = new ArrayList<>();
        //遍历JSONarray
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            double english = object.getDouble("english");
            double maths = object.getDouble("maths");
            Word word = new Word(english, maths);
            list.add(word);
        }
        System.out.println(list);
    }

}
