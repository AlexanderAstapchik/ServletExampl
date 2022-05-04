<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.04.2022
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calc" method="post">
    <input type="number" placeholder="Number 1" name="num1">
    <input type="number" placeholder="Number 2" name="num2">
    <select name="operation">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <button>Submit</button>
    <%--@declare id="result"--%> <p><label class="form-label" for="result"> your result:</label>
   <span name="result">${result}</span></p>
</form>

</body>
</html>