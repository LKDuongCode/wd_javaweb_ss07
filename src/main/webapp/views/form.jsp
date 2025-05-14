<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Feedback Form</title></head>
<body>
<h2>Feedback Form</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/feedback/submit" method="post">
    Họ và tên: <input type="text" name="fullName" value="${feedback.fullName}"><br><br>
    Số điện thoại: <input type="text" name="phone" value="${feedback.phone}"><br><br>
    Địa chỉ: <input type="text" name="address" value="${feedback.address}"><br><br>
    Nội dung góp ý: <br>
    <textarea name="content" rows="5" cols="30">${feedback.content}</textarea><br><br>
    <button type="submit">Gửi góp ý</button>
</form>
</body>
</html>
