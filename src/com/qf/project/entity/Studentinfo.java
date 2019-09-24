package com.qf.project.entity;

public class Studentinfo {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String ys;
    private String classname;
    private String hiredate;
    private String tel;
    private String jg;
    private String  flag;

    public Studentinfo() {
    }

    public Studentinfo(int id, String name, String sex, int age, String ys, String classname, String hiredate, String tel, String jg, String flag) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.ys = ys;
        this.classname = classname;
        this.hiredate = hiredate;
        this.tel = tel;
        this.jg = jg;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Studentinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", ys='" + ys + '\'' +
                ", classname='" + classname + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", tel='" + tel + '\'' +
                ", jg='" + jg + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getYs() {
        return ys;
    }

    public void setYs(String ys) {
        this.ys = ys;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
