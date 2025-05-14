<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 10:00
  hw06+07 ----
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Product List</title></head>
<body>

<h2>Product List</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<table border="1">
    <tr>
        <th>Image</th><th>Name</th><th>Price</th><th>Stock</th><th>Action</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><img src="${product.image}" width="100" height="100" alt="${product.name}"></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>
                <a href="${pageContext.request.contextPath}/list/details?id=${product.id}">View Details</a>
                <form action="${pageContext.request.contextPath}/list/addToCart" method="post" style="margin-top: 5px;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="number" name="quantity" value="1" min="1" style="width: 50px;">
                    <button type="submit">Add to Cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/list/cart">View Cart</a>

</body>
</html>
