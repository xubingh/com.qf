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
@WebServlet("/servletupdate")
public class Servletupdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置代码编译
        req.setCharacterEncoding("utf-8");
        //2.获取从web端传入的数据
        String id = req.getParameter("id");

        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String ys = req.getParameter("ys");
        String classname = req.getParameter("classname");
        String hiredate = req.getParameter("hiredate");
        String tel = req.getParameter("tel");
        String jg = req.getParameter("jg");
        String flag = req.getParameter("flag");
        //3.封装为对象
        Studentinfo stu  = new Studentinfo();
        stu.setId(Integer.parseInt(id));

        stu.setName(name);
        stu.setSex(sex);
        stu.setAge(Integer.parseInt(age));
        stu.setYs(ys);
        stu.setClassname(classname);
        stu.setHiredate(hiredate);
        stu.setTel(tel);
        stu.setJg(jg);
        stu.setFlag(flag);
        System.out.println("id查询的数据"+stu);
        //4.调用dao层修改update的方法
        StudentinfoDao dao = new StudentinfoDaoImpl();
        int rows = dao.update(stu);
        if (rows>0) {
            req.getRequestDispatcher("/servletstudentinfo").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/exception.jsp");
        }


    }

}
