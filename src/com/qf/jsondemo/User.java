package com.qf.jsondemo;

public class User {
    private String name;
    private int age;
    private Word word;

    public User() {
    }


    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", word=" + word +
                '}';
    }

    public User(String name, int age, Word word) {
        this.name = name;
        this.age = age;
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
