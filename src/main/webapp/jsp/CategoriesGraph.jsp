<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/CategoriesGraph.css">
</head>
<body>

<form action="${pageContext.request.contextPath}/channelKeywordRecom/analyzeContents" method="GET">
<input type="text" name="channel_name" value="호중이바보">
<input type="submit" value="000000000000000000000000">
</form>

<form action="${pageContext.request.contextPath}/channelKeywordRecom/list" method="POST">
<input type="text" name="channel_name" value="호중이바보">
<input type="submit" value="000000000000000000000000">
</form>
<table id="key">
	<tr>
		<th colspan="5"><h2>&#60;주요 키워드&#62;</h2></th>
	</tr>
	<tr>
		<td colspan="5" id="aa"><a id="bb">키워드를 클릭하시면 자동검색 페이지가 나옵니다.</a><br>&nbsp;</td>
	</tr>
	<tr class="keyword">
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword1}">${requestScope.keyword1}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword2}">${requestScope.keyword2}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword3}">${requestScope.keyword3}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword4}">${requestScope.keyword4}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword5}">${requestScope.keyword5}</a></td>
	</tr>
	<tr><th>&nbsp;</th></tr>
	<tr class="entity">
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword6}">${requestScope.keyword6}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword7}">${requestScope.keyword7}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword8}">${requestScope.keyword8}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword9}">${requestScope.keyword9}</a></td>
		<td><a href="https://www.google.co.kr/search?q=${requestScope.keyword10}">${requestScope.keyword10}</a></td>
	</tr>
	<tr><td colspan="5">&nbsp;<hr style="size:5px;">&nbsp;</td></tr>
	<tr>
		<th colspan="5"><h2>&#60;대화 주제 TOP3&#62;</h2></th>
	</tr>
	<tr id="category">
		<th colspan="5"><div id="donut_example"></div></th>
	</tr>
</table>
<script>
Morris.Donut({
	element : 'donut_example',
	data : [
		{label : '${requestScope.category1}', value : ${requestScope.per1}},
		{label : '${requestScope.category2}', value : ${requestScope.per2}},
		{label : '${requestScope.category3}', value : ${requestScope.per3}},
	],
	colors : ["#001a4d", "#193366", "#b3b3e6"],
	formatter : function(y) {return y+"%"}
});
</script>
</body>
</html>