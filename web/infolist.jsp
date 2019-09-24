<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/23
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面展示表</title>
</head>
<body>
<p align="center">
    <a href="${pageContext.request.contextPath}/servletstudentinfo">展示学生信息列表</a>
</p>
<c:if test="${not empty listes}">
    <div>
        <a href="${pageContext.request.contextPath}/add.jsp">添加</a>
        <a href="javascript:void(0);" onclick="removeStu()">批量删除</a>
    </div>
    <form action="${pageContext.request.contextPath}/servletstudentinfo" method="post">
    <table border="1" cellpadding="0" cellspacing="0" align="center" width="100%">
        <caption>商品展示表</caption>
        <tr>
            <td>
                <input type="checkbox" name="uid"/>
            </td>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>院系</td>
            <td>班级</td>
            <td>入校时间</td>
            <td>电话</td>
            <td>籍贯</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${listes}" var="list" varStatus="s">
            <tr>
                <td>
                    <input type="checkbox" name="uid" value="#"/>
                </td>
                <td>${s.count}</td>
                <td>${list.name}</td>
                <td>${list.sex}</td>
                <td>${list.age}</td>
                <td>${list.ys}</td>
                <td>${list.classname}</td>
                <td>${list.hiredate}</td>
                <td>${list.tel}</td>
                <td>${list.jg}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/servletupdate.jsp?id=${list.id}">编辑</a>
                    |
                    <a href="${pageContext.request.contextPath}/servletdelete?uid=${list.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</c:if>
</body>
</html>
