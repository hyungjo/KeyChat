<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" flush="false"/>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('${pageContext.request.contextPath}/img/pic.jpg');">
    <img class="img-fluid d-block mx-auto" src="http://placehold.it/200x200&text=Logo" alt="">
</header>

<!-- Content section -->
<section class="py-5 bg-not">
    <div class="container">
        <h1>KeyChat</h1>
        <p class="lead">불필요한 회의 시간, 다양한 추천 키워드 제시</p>
        <p>KeyChat Messenger로 생산성을 높이세요!</p>
    </div>
</section>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('${pageContext.request.contextPath}/img/pic.jpg');">
    <!-- Put anything you want here! There is just a spacer below for demo purposes! -->
    <div style="height: 600px;"></div>
</header>

<!-- Content section -->
<section class="py-5 bg-not">
    <div class="container">
        <h1>KeyChat</h1>
        <p class="lead">불필요한 회의 시간, 다양한 추천 키워드 제시</p>
        <p>KeyChat Messenger로 생산성을 높이세요!</p>
    </div>
</section>

<jsp:include page="footer.jsp" flush="false"/>