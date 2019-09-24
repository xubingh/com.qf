package com.qf.project.utile;

import java.io.IOException;
import java.util.Properties;

public class Dutile {
    /**
     * properties : 属性
     * getClassLoader : 类加载
     * getResourceAsStream : 资源流
     */
    static Properties pro = null;
    static{
         pro = new Properties();
        try {
            pro.load(Dutile.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String key){
        String value = pro.getProperty(key);
        return value;
    }

    public static void main(String[] args) {
        String url = getValue("url");
        System.out.println(url);
    }
}
