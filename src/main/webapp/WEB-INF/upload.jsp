<%--
  Created by IntelliJ IDEA.
  User: ahyun
  Date: 2021-08-20
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/upload" method="post" enctype="multipart/form-data"> <!--반드시 enctype="multipart/form-data 줘야함 -->
        <input type="text" name="title" value="test...">
        <input type="file" name="uploadFiles" multiple> <!--multiple : 입력하는 창은 하나, 파일은 여러개 업로드 가능-->
        <button type="submit">Submit</button>
    </form>

</body>
</html>
