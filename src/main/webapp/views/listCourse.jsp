<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Danh sách khóa học</title></head>
<body>
<h2>Danh sách khóa học</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.description}</td>
            <td><a href="delete/${course.id}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
<a href="add">Thêm khóa học</a>
</body>
</html>

