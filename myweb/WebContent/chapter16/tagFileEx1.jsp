<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib tagdir="/WEB-INF/tags/chapter16"  prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>제목 태그</h1>

<my:myTag/>
<my:myTag2 />
<my:myTag3>
내용물..
</my:myTag3>
<br>
<my:triangle>
*
</my:triangle>
<my:triangle>
#
</my:triangle>
</body>
</html>