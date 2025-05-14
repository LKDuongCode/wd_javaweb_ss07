<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Product</title></head>
<body>
<h2>Add Product</h2>
<form action="${pageContext.request.contextPath}/products/save" method="post">
  Name: <input type="text" name="name" value="${product.name}"><br>
  Price: <input type="number" step="0.01" name="price" value="${product.price}"><br>
  Category:
  <select name="categoryId">
    <c:forEach var="category" items="${categories}">
      <option value="${category.id}" ${category.id == product.categoryId ? 'selected' : ''}>${category.name}</option>
    </c:forEach>
  </select><br>
  <button type="submit">Save</button>
</form>
</body>
</html>

