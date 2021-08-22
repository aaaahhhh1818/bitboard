<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

alert(num) //브라우저 멈춰 !!! 뒤로 가기해도 경고창 뜸
<script>
    if(num) { //num 값이 널이라면 실행안함
        window.history.replaceState(null, '', '/board/list'); //뒤로가기 했을 때 url 값 처리
    }

</script>
let num = '${param.bno}' //url에 있는 파라미터 추출



<h1>List page</h1>

<h4>${pageMaker}</h4>

<a href="/board/register">글쓰기</a>
<form action="/board/list" method="get">
    <input type="hidden" name="page" value="1"> <!--폼 창 기본값 설정-->
    <select name="size">
        <option value="10" ${pageMaker.size == 10?"selected":""}>10</option>
        <option value="20" ${pageMaker.size == 20?"selected":""}>20</option>
        <option value="50" ${pageMaker.size == 50?"selected":""}>50</option>
        <option value="100" ${pageMaker.size == 100?"selected":""}>100</option>
    </select>
    <button type="submit">적용</button>
</form>

<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <div>
                <div>${dto.bno}</div>
                <div><a href="/board/read?bno=${dto.bno}&page=${pageMaker.page}&size=${pageMaker.size}">${dto.title}</a></div>
                <div>${dto.viewcount}</div>
            </div>
        </li>
    </c:forEach>
</ul>

<hr/>

<style>

    .pageList {
        list-style: none;
        display: flex;
        flex-direction: row;
    }

    .pageList li {
        margin-left: 0.3em;
        background-color: green;
        font-family: "Roboto Light";
        border: 1px solid greenyellow;
    }

    .current {
        color: crimson;
    }

</style>
<ul class="pageList">

    <c:if test="${pageMaker.prev}">
        <li><a href="/board/list?page=${pageMaker.start -1}&size=${pageMaker.size}">PREV</a></li>
    </c:if>

    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="page">
        <li class="${page == pageMaker.page?"current":""}"><a href="/board/list?page=${page}&size=${pageMaker.size}">${page}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next}">
        <li><a href="/board/list?page=${pageMaker.end +1}&size=${pageMaker.size}">NEXT</a></li>
    </c:if>
</ul>


</body>
</html>
