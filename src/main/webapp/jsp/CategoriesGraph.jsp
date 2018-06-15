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
</head>
<body>
<div id="donut_example" style="height: 250px;"></div>
<script>
Morris.Donut({
	element : 'donut_example',
	data : [
		{label : '${requestScope.category1}', value : ${requestScope.per1}},
		{label : '${requestScope.category2}', value : ${requestScope.per2}},
		{label : '${requestScope.category3}', value : ${requestScope.per3}},
	],
	colors : ["#30a1ec", "#76bdee", "#c4dafe"],
	formatter : function(y) {return y+"%"}
});
</script>
</body>
</html>