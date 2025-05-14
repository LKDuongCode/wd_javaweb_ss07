<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Feedback Result</title></head>
<body>
<h2>Feedback Submitted Successfully</h2>
<table border="1">
  <tr><th>Field</th><th>Value</th></tr>
  <tr><td>Họ và tên</td><td>${feedback.fullName}</td></tr>
  <tr><td>Số điện thoại</td><td>${feedback.phone}</td></tr>
  <tr><td>Địa chỉ</td><td>${feedback.address}</td></tr>
  <tr><td>Nội dung góp ý</td><td>${feedback.content}</td></tr>
</table>

<a href="${pageContext.request.contextPath}/feedback/list">Xem danh sách góp ý</a><br>
<a href="${pageContext.request.contextPath}/feedback/form">Gửi góp ý mới</a>
</body>
</html>

