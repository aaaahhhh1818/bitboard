<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-19
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${boardDTO}</div>
<div>${pageDTO}</div>
<form action="/board/delete" method="post">
    <input type="hidden" name="bno" value="${boardDTO.bno}" readonly>
    <input type="text" name="title" value="${boardDTO.title}" readonly>
    <input type="text" name="content" value="${boardDTO.content}" readonly>
    <input type="text" name="writer" value="${boardDTO.writer}" readonly>
    <input type="text" name="regdate" value="${boardDTO.regdate}" readonly>
    <input type="text" name="updatedate" value="${boardDTO.updatedate}" readonly>
    <button type="submit">삭제하기</button>
</form>
<a href="/board/update?bno=${boardDTO.bno}">수정하기</a>
<a href="/board/list?page=${pageDTO.page}&size=${pageDTO.size}">목록가기</a>
</body>
</html>
