<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 10:01
  hw06+07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Product Details</title></head>
<body>
<h2>Product Details</h2>
<img src="${product.image}" width="200" height="200" alt="${product.name}"><br>
<p><strong>Name:</strong> ${product.name}</p>
<p><strong>Price:</strong> ${product.price}</p>
<p><strong>Stock:</strong> ${product.stock}</p>
<p><strong>Description:</strong> ${product.description}</p>
<a href="${pageContext.request.contextPath}/list">Back to List</a>
</body>
</html>
