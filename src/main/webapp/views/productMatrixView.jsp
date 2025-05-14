<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 14/05/2025
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Matrix Variable Filters</title></head>
<body>
<h2>Filter Products</h2>
<p>Filter Type: ${type}</p>
<h3>Applied Filters:</h3>
<ul>
    <c:forEach var="entry" items="${filters}">
        <li>${entry.key} = ${entry.value}</li>
    </c:forEach>
</ul>
</body>
</html>

