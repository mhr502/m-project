<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/chap12" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
<select name="hero">
<option value="ironman">아이언맨</option>
<option value="captain">캡틴</option>
<option value="black">블랙위도우</option>
</select>
<input type="submit" >
</form>
<!-- page attribute에 변수가 저장됨> 리퀘스트 영역-->
<c:if test="${empty param.hero }" var="hasNotHero" scope="request">     
영웅을 선택해주세요.
</c:if>
<c:if test="${param.hero eq 'ironman'}" var="isIronman" scope="request">
아이언맨은 로버트 다우니 주니어입니다.
</c:if>
<c:if test="${param.hero eq 'captain'}" var="isCaptain" scope="request">
캡틴은 크리스 에반스입니다.
</c:if>
<c:if test="${param.hero eq 'black'}" var="isBlack" scope="request">
블랙위도우은 스칼렛 요한슨입니다.
</c:if>
<br>
<c:if test="${hasNotHero }">
<img src="default.jpg">
</c:if>
<c:if test="${isIronman}">
<img src="ironman.jpg">
</c:if>
<c:if test="${isCaptain}">
<img src="captain.jpg">
</c:if>
<c:if test="${isBlack}">
<img src="black.jpg">
</c:if>
<br>

<my:img/>

</body>
</html>









