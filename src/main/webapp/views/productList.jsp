<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Product List</title></head>
<body>
<h2>Product List</h2>
<form method="get" action="">
    <input type="text" name="keyword" value="${keyword}" placeholder="Search product">
    <button type="submit">Search</button>
</form>
<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Price</th><th>Category</th><th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td><a href="${pageContext.request.contextPath}/products/${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>
                <c:forEach var="category" items="${categories}">
                    <c:if test="${category.id == product.categoryId}">${category.name}</c:if>
                </c:forEach>
            </td>
            <td>
                <a href="edit/${product.id}">Edit</a>
                <a href="delete/${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${totalPage > 1}">
    <div>
        <c:forEach begin="1" end="${totalPage}" var="i">
            <a href="?keyword=${keyword}&page=${i}">${i}</a>
        </c:forEach>
    </div>
</c:if>
<a href="add">Add Product</a>
</body>
</html>
