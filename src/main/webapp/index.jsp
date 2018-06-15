<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" flush="false"/>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('${pageContext.request.contextPath}/img/pic.jpg');">
    <img class="img-fluid d-block mx-auto" src="http://placehold.it/200x200&text=Logo" alt="">
</header>

<!-- Content section -->
<section class="py-5">
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
<section class="py-5">
    <div class="container">
        <h1>KeyChat</h1>
        <p class="lead">불필요한 회의 시간, 다양한 추천 키워드 제시</p>
        <p>KeyChat Messenger로 생산성을 높이세요!</p>
    </div>
</section>

<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <%--<div class="modal-header">--%>
            <%--<h5 class="modal-title" id="exampleModalLabel">로그인</h5>--%>
            <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
            <%--<span aria-hidden="true">&times;</span>--%>
            <%--</button>--%>
            <%--</div>--%>
            <div class="modal-body modal-form form-signin">
                <h3 class="form-signin-heading">로그인</h3>
                <hr class="colorgraph"><br>

                <input type="text" class="form-control" id="emailInput" placeholder="이메일">
                <input type="password" class="form-control" id="passwordInput" placeholder="비밀번호">

                <button class="btn btn-lg btn-block" id="login" data-dismiss="modal" onclick="login()">로그인</button>
            </div>
            <%--<div class="modal-footer">--%>
            <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
            <%--<button type="button" class="btn btn-lg btn-block" data-dismiss="modal" onclick="login()">로그인</button>--%>
            <%--<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="login()">로그인</button>--%>
            <%--</div>--%>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" flush="false"/>