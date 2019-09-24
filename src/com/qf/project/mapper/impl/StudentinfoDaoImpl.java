package com.qf.project.mapper.impl;

import com.qf.project.entity.Studentinfo;
import com.qf.project.mapper.StudentinfoDao;
import com.qf.project.utile.Close;
import com.qf.project.utile.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class StudentinfoDaoImpl implements StudentinfoDao {
    /**
     * 查询列表
     * @return
     */
    @Override
    public List<Studentinfo> getList() {
        List<Studentinfo> infolist = new ArrayList<>();
        Connection conn=null;
        PreparedStatement sta =null;
        ResultSet rs=null;
        try {
            //1.连接数据库
            conn = JDBC.getConnection();
            System.out.println("数据库连接"+conn
            );
            //2.定义sql语句子查询没有没有逻辑删除的数据
            String sql = "select * from studentinfo where flag='0'";
            //3.创建执行sql语句执行的对象
            sta = conn.prepareStatement(sql);
            //4.执行sql语句
            rs = sta.executeQuery();
            //5.处理结果集
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String ys = rs.getString("ys");
                String aClass = rs.getString("class");
                String hiredate = rs.getString("hiredate");
                String tel = rs.getString("tel");
                String jg = rs.getString("jg");
                String flag = rs.getString("flag");
                //6.将数据封装到对象
                Studentinfo stu = new Studentinfo();

                stu.setId(id);
                stu.setName(name);
                stu.setSex(sex);
                stu.setAge(age);
                stu.setYs(ys);
                stu.setClassname(aClass);
                stu.setHiredate(hiredate);
                stu.setTel(tel);
                stu.setJg(jg);
                stu.setFlag(flag);

                //7.将对象放入到集合中
                infolist.add(stu);
                return infolist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(conn,sta,rs);
        }
        return null;
    }

    /**
     * 根据id 查询数据库记录,用于显示在修改页面
     * @param id
     * @return
     */
    @Override
    public Studentinfo findById(int id) {
        Connection conn=null;
        PreparedStatement sta=null;
        ResultSet rs=null;

        try {
            conn = JDBC.getConnection();
            String sql="select * from  studentinfo where id=?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1,id);
            rs = sta.executeQuery();
            while (rs.next()){
                int anInt = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String ys = rs.getString("ys");
                String classname = rs.getString("classname");
                String hiredate = rs.getString("hiredate");
                String tel = rs.getString("tel");
                String jg = rs.getString("jg");
                String flag = rs.getString("flag");
                //封装为对象
                Studentinfo stu = new Studentinfo();

                stu.setId(id);
                stu.setName(name);
                stu.setSex(sex);
                stu.setAge(age);
                stu.setYs(ys);
                stu.setClassname(classname);
                stu.setHiredate(hiredate);
                stu.setTel(tel);
                stu.setJg(jg);
                stu.setFlag(flag);
                return stu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(conn,sta,rs);
        }
        return null;
    }

    /**
     * 添加一条记录
     * @param studentinfo
     * @return
     */
    @Override
    public int add(Studentinfo studentinfo) {
        Connection conn= null;
        PreparedStatement sta=null;
        try {

            //1.连接数据库
            conn = JDBC.getConnection();
            //2.获取sql语句对象
            String sql = "insert into studentinfo(name,sex,age,ys,class,hiredate,tel,jg,flag)values " +
                    "(?,?,?,?,?,?,?,?,?)";
            //3.执行sql语句
            sta = conn.prepareStatement(sql);
            //4.预编译设置参数()
            sta.setString(1,studentinfo.getName());
            sta.setString(2,studentinfo.getSex());
            sta.setInt(3,studentinfo.getAge());
            sta.setString(4,studentinfo.getYs());
            sta.setString(5,studentinfo.getClassname());
            sta.setString(6,studentinfo.getHiredate());
            sta.setString(7,studentinfo.getTel());
            sta.setString(8,studentinfo.getJg());
            sta.setString(9,"0");

            int rows = sta.executeUpdate();
            System.out.println("受影响的行数"+rows);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(conn,sta,null);
        }
        return -1;
    }

    @Override
    public int update(Studentinfo studentinfo) {
        Connection conn=null;
        PreparedStatement sta=null;
        try {
            //1.连接数据库
            conn = JDBC.getConnection();
            //2.获取sql对象
            String sql="update studentinfo set name=?,sex=?,age=?,ys=?," +
                    "class=?,hiredate=?,tel=?,jg=? where id=?";
            //3.预编译sql语句
            sta = conn.prepareStatement(sql);
            sta.setString(1,studentinfo.getName());
            sta.setString(2,studentinfo.getSex());
            sta.setInt(3,studentinfo.getAge());
            sta.setString(4,studentinfo.getYs());
            sta.setString(5,studentinfo.getClassname());
            sta.setString(6,studentinfo.getHiredate());
            sta.setString(7,studentinfo.getTel());
            sta.setString(8,studentinfo.getJg());

            sta.setInt(9,studentinfo.getId());
            //4.执行sql语句,返回受影响的行数
            int rows = sta.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(conn,sta,null);
        }
        return -1;
    }

    /**
     * 删除一条记录
     * @param uid
     * @return
     */
    @Override
    public int delete(String uid) {
        Connection conn=null;
        PreparedStatement sta=null;
        try {
            //1.连接数据库
            conn = JDBC.getConnection();
            //2.获取sql对象
            String sql="update studentinfo set flag=? where id="+uid+"";
            //3.执行sql语句
            sta = conn.prepareStatement(sql);
            Studentinfo stu = new Studentinfo();
            sta.setString(1,"1");
//            sta.setInt(2,stu.getId());
            int rows = sta.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.close(conn,sta,null);
        }
        return -1;
    }
}
