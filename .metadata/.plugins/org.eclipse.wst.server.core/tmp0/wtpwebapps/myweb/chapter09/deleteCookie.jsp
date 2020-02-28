<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import ="java.net.URLEncoder" %>
        <%
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length>0){
        	for( int i=0; i<cookies.length;i++){
        		if(cookies[i].getName().equals("name")){
        			Cookie cookie = new Cookie("name","");
        			cookie.setMaxAge(0);
        			response.addCookie(cookie);
        		}
        	}
        }
        
        
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>쿠키 삭제</title>
</head>
<body>
name 쿠키를 삭제합니다.
</body>
</html>