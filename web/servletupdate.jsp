<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/23
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>

<form action="/servletupdate" method="post">
    <%--用隐藏域记录编辑页面的学生信息的id,不让用户看到
    因为等下更新的时候，需要根据id去更新相应的记录--%>
    <input type="hidden" name="id" value="${byid.id}"/>
    <%--flag是一个标识删除的字段，不会让用户更新，所以是隐藏域--%>
    <input type="hidden" name="flag" value="${byid.flag}"/>


    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" value="${byid.name}"/>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男"<c:if test="${byid.sex=='男'}">checked</c:if>/>男
                <input type="radio" name="sex" value="女"<c:if test="${byid.sex=='女'}">checked</c:if>/>女
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" value="${byid.age}"/>
            </td>
        </tr>
        <tr>
            <td>院系</td>
            <td>
                <input type="text" name="ys" value="${byid.ys}"/>
            </td>
        </tr>
        <tr>
            <td>班级</td>
            <td>
                <input type="text" name="classname" value="${byid.classname}"/>
            </td>
        </tr>
        <tr>
            <td>入校时间</td>
            <td>
                <input type="date" name="hiredate" value="${byid.hiredate}"/>
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <input type="text" name="tel" value="${byid.tel}"/>
            </td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td>
                <input type="text" name="jg" value="${byid.jg}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="submit" value="提交"/>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
