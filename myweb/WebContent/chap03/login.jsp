<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("memberid");
	if (id != null && id.equals("snowman")) {
		//현재 기준 상대 경로
		response.sendRedirect("index.jsp");
		//서버 기준 절대 경로
		//response.sendRedirect("/my/chapter03/index.jsp");
		// 외부 경로
		//response.sendRedirect("https://www.naver.com");
	} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인에 실패</title>
</head>
<body>
잘못된 아이디입니다.

<%
out.println("hi");

%>

</body>
</html>
<%
	}//주석
%>