package com.qf;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/uploadServlet")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            upload(req,resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
    public void upload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        //1,获取磁盘的工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2,根据工厂获取上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3,解析请求
        List<FileItem> list = upload.parseRequest(request);
        for(FileItem fileItem:list){
            //System.out.println(fileItem);
            //4,根据isFormField()判断是否是上传文件
            if(!fileItem.isFormField()){
                //5,获取对象的输入流
                InputStream is = fileItem.getInputStream();

                //6,设置一下上传路径
                String uploadPath = "F:\\test\\"+fileItem.getName();
                System.out.println("uploadPath:"+uploadPath);

                //7,创建输出流
                FileOutputStream fos = new FileOutputStream(uploadPath);
                //8,文件的读写操作

                byte[] buff = new byte[1024];
                int len=0;
                while((len=is.read(buff))!=-1){
                    fos.write(buff,0,len);
                }
                //9,关闭资源
                fos.close();
                is.close();
            }
        }
    }

}
