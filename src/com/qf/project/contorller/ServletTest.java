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
import java.util.List;
@WebServlet("/servletstudentinfo")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理代码编译问题
        req.setCharacterEncoding("utf-8");
        //获取dao层
        StudentinfoDao stu = new StudentinfoDaoImpl();
        //获取dao层里面的信息表
        List<Studentinfo> list = stu.getList();
        System.out.println("查看信息表"+list.size());
        //放到request域中,方便jsp调用
        req.setAttribute("listes",list);
        req.getRequestDispatcher("/infolist.jsp").forward(req,resp);

    }
}
