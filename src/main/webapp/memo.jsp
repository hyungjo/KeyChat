<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/channelMemo" method="POST">
	<textarea name="contents" rows="30" cols="50"></textarea>
	<br>
	<input type ="button" value ="불러오기" onclick="location.href='channelmemo?command=list">
	
	<input type ="button" value ="만들기" onclick="location.href='channelmemo?command=create'">
	
	<input type ="button" value ="삭제" onclick="location.href='channelmemo?command=delete">
</form>

</body>
</html>