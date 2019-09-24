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
@WebServlet("/servletdelete")
public class ServletDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置代码编译
        req.setCharacterEncoding("utf-8");
        //2.拿到删除的行的位置
        String uids = req.getParameter("uid");
//        Studentinfo stu = new Studentinfo();
//        stu.setId(Integer.parseInt(uids));
        //3.调用dao层的delete方法
        StudentinfoDao dao = new StudentinfoDaoImpl();
        //4.把要删除的行的位置传进去
        int delete = dao.delete(uids);
        if (delete>0){
            req.getRequestDispatcher("/servletstudentinfo").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/exception");
        }
    }
}
