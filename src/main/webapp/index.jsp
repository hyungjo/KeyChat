<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" flush="false"/>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('${pageContext.request.contextPath}/img/pic.jpg');">
    <div class="img-fluid d-block mx-auto" style="height: 500px;"></div>
</header>

<!-- Content section -->
<section class="py-5 bg-not">
    <div class="container">
        <img src="${pageContext.request.contextPath}/img/text.png" width="180px" height="60px">
        <p class="lead">불필요한 회의 시간, 다양한 추천 키워드 제시</p>
        <p>KeyChat Messenger로 생산성을 높이세요!</p>
    </div>
</section>

<section class="py-5 bg-not">
    <div class="container">
        <img src="img/channelsRoom_Text.jpg" width="100%" height="500px">
    </div>
</section>

<section class="py-5 bg-not">
    <div class="container">
        <img src="img/chating_Text.png" width="100%" height="500px">
    </div>
</section>

<jsp:include page="footer.jsp" flush="false"/>