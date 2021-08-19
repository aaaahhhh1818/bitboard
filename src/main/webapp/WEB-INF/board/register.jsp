<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-19
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/board/register" method="post">
        <input type="text" name="title">
        <textarea name="content"></textarea>
        <input type="text" name="writer">
        <button type="submit">등록</button>
    </form>

</body>
</html>
