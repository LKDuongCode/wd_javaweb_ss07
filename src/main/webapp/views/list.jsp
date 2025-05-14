<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Feedback List</title></head>
<body>
<h2>Feedback List</h2>
<c:if test="${empty feedbackList}">
  <p>Chưa có góp ý nào.</p>
</c:if>
<c:if test="${not empty feedbackList}">
  <table border="1">
    <tr><th>Họ và tên</th><th>Số điện thoại</th><th>Địa chỉ</th><th>Nội dung góp ý</th></tr>
    <c:forEach var="item" items="${feedbackList}">
      <tr>
        <td>${item.fullName}</td>
        <td>${item.phone}</td>
        <td>${item.address}</td>
        <td>${item.content}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<a href="${pageContext.request.contextPath}/feedback/form">Gửi góp ý mới</a>
</body>
</html>
