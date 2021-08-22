<%--
  Created by IntelliJ IDEA.
  User: ahyun
  Date: 2021-08-22
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/board/update" method="post">
    <input type="hidden" name="bno" value="${bno}">
    <input type="text" name="title">
    <textarea name="content"></textarea>
    <input type="text" name="writer" value="${boardDTO.writer}" readonly>
    <button type="submit">등록</button>
</form>

</body>
</html>
