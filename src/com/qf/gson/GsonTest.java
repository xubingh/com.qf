package com.qf.gson;
/**
 * json字符串转成java对象
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.jsondemo.User;
import com.qf.jsondemo.Word;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 谷歌公司提供的接送解析器
 */
public class GsonTest {
    @Test
    public void test1(){
        //简单形式转成json字符串
        String gson = "{name=小明,age=23}";
        Gson gson1 = new Gson();
        //谷歌公司的解析器,通过字节码的反射机制,
        // 可以完成的字符串转成对象的事情
        User user1 = gson1.fromJson(gson, User.class);
        System.out.println(user1);
    }
    @Test
    public void test2(){
        //复杂形式转成json字符串
        //对象里面嵌套了对象
        String gson="{name=小明,age=23,word:{english=55,maths=65}}";
        Gson gson1 = new Gson();
        User user = gson1.fromJson(gson, User.class);
        System.out.println(user);
    }


    /**
     * 集合形式的json字符串
     */
    @Test
    public void test3(){
        String json="[{english=55,maths=88},{english=58,maths=78}]";
        //实例化Gson对象
        Gson gson = new Gson();
//        调用Gson的方法进行转换
//        ArrayList list = gson.fromJson(json, ArrayList.class);
//        for (Object o : list) {
//            System.out.println(o);
//        }

        /**
         * 第二种形式
         */

        TypeToken<ArrayList<Word>> token = new TypeToken<ArrayList<Word>>() {};
        ArrayList<Word> list = gson.fromJson(json,token.getType());
        for (Word word : list) {
            System.out.println(word);
        }
    }
}























