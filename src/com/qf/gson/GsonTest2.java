package com.qf.gson;

import com.google.gson.Gson;
import com.qf.jsondemo.Word;
import org.junit.Test;

import java.util.ArrayList;

/**
 * java对象转成json字符串
 */
public class GsonTest2 {
    @Test
    public void test(){
        //1.普通的对象转换成json字符串
        Word word = new Word(34, 23);
        Gson gson = new Gson();
        String s = gson.toJson(word);
        System.out.println("Java对象转成json字符串"+s);
    }
    /**
     * 集合转成json字符串
     *
     */
    @Test
    public void test2(){
        ArrayList<Word> list = new ArrayList<>();
        Word word = new Word(88.5, 66.4);
        Word word1 = new Word(64, 77.5);
        list.add(word);
        list.add(word1);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println("集合转成json字符串"+json);
    }
}
