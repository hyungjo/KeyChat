<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>
<div class="container" style="min-height: 735px; padding-top: 80px; padding-bottom: 0px;">
	<P>회원님의 E-Mail은 <strong>${ requestScope.res }</strong>입니다.</P>
	<input type="button" value="홈페이지로 돌아가기" onclick="location.href='/index.jsp'">
	<input type="button" value="비밀번호 찾기" onclick="location.href='/jsp/search.jsp'">
</div>
<jsp:include page="/footer.jsp" flush="false"/>