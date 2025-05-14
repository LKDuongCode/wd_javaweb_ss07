<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<html>
<head><title>Product Details</title></head>
<body>
<h2>Product Details</h2>
<p>ID: ${product.id}</p>
<p>Name: ${product.name}</p>
<p>Price: ${product.price}</p>
<p>Category:
  <c:forEach var="category" items="${categories}">
    <c:if test="${category.id == product.categoryId}">${category.name}</c:if>
  </c:forEach>
</p>
<a href="${pageContext.request.contextPath}/products">Back to List</a>
</body>
</html>

