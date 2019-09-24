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
@WebServlet("/servletid")
public class ServletId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.获取参数
        String id = req.getParameter("id");
        //2.根据id查询数据
        StudentinfoDao stu = new StudentinfoDaoImpl();
        //3.根据id拿到学生的对象
        Studentinfo byId = stu.findById(Integer.parseInt(id));
        System.out.println("查看"+byId);

        //4.把id存放到request域中
        req.setAttribute("byid",byId);
        //5.把数据转发给修改页面显示
        req.getRequestDispatcher("/servletupdate.jsp").forward(req,resp);

    }


}
