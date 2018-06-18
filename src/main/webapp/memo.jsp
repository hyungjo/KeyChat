<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script>
	function list(){
		${list}
	}


</script>
<body>

<form action="channelMemo/list" method="POST">
<textarea name="contents" rows="30" cols="50"></textarea>
<br>
<input type = "submit" value ="보기" onclick="list()">
</form>

<form action="channelMemo/create" method="POST">
<input type = "submit" value ="삭제">
</form>

<form action="channelMemo/delete" method="POST">
<input type = "submit" value ="추가">
</form>


</body>
</html>