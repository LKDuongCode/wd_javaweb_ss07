<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Thêm khóa học mới</title></head>
<body>
<h2>Thêm khóa học mới</h2>
<form action="add" method="post">
    <label for="name">Tên khóa học:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="description">Mô tả:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <input type="submit" value="Thêm mới">
</form>
</body>
</html>

