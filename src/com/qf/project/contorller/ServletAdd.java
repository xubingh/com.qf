package com.qf.project.contorller;

import com.qf.project.entity.Studentinfo;
import com.qf.project.mapper.StudentinfoDao;
import com.qf.project.mapper.impl.StudentinfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/servletadd")
public class ServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编译
        req.setCharacterEncoding("utf-8");
        //2.获取web端输入的数据
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        System.out.println("查看是否乱码"+sex);
        String age = req.getParameter("age");
        String ys = req.getParameter("ys");
        String classname = req.getParameter("classname");
        String hiredate = req.getParameter("hiredate");
        String tel = req.getParameter("tel");
        String jg = req.getParameter("jg");

        //3.封装对象
        Studentinfo stu = new Studentinfo();
        stu.setName(name);
        stu.setSex(sex);
        stu.setAge(Integer.parseInt(age));
        stu.setYs(ys);
        stu.setClassname(classname);
        stu.setHiredate(hiredate);
        stu.setTel(tel);
        stu.setJg(jg);

        //4.调用dao层的方法
        StudentinfoDao dao = new StudentinfoDaoImpl();
        //5.把封装的对象传给dao层,编译数据库语句,返回受影响的行数
        int rows = dao.add(stu);
        //6.判断是否添加成功
        if (rows>0){
            req.getRequestDispatcher("/servletstudentinfo").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/exception");
        }

    }
}
