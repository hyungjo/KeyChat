<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.keychat.dto.base.UsersModel"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainPage.css">

    <title>KeyChat Service</title>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">KEY(로고)</h3>
                    <ul class="nav center_menu">
                        <li><a href="#">채널</a></li>
                        <li><a href="#">공지사항</a></li>
                    </ul>
                    <ul class="nav masthead-nav">
                        <li id="loginBtn"><a href="#" data-toggle="modal" data-target="#loginModal">로그인</a></li>
                        <li id="nicknameField" style="display: none"><a href="#" id="nickname"></a></li>
                        <li id="logoutBtn" style="display: none"><a href="#" onclick="logout()">로그아웃</a></li>
                        <li id="signupBtn">회원가입</li>
                    </ul>
                </div>
            </div>

            <div class="inner_cover">
                <img class="mainPic" src="${pageContext.request.contextPath}/img/pic.jpg">
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <!-- Validation -->
                    <p>
                        <a href="#">
                            <small>회사소개</small></a>
                        <a>|</a>
                        <a href="#">
                            <small>이용약관</small></a>
                        <a>|</a>
                        <a href="#">
                            <small>개인정보처리방침</small></a>
                    </p>

                    <p>
                        © 2018 SIAT2.0 <a href="#">KeyChat</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input id="emailInput" type="text" class="form-control" name="Username" placeholder="이메일">
                <input id="passwordInput" type="password" class="form-control" name="Password" placeholder="비밀번호">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="login()">로그인</button>
            </div>
        </div>
    </div>
</div>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script>
    function setUserNickname() {
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/info',
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                $("#nickname").text(response.result.nickname);
            },
            error: function (response) {
                console.log(response);
            }
        });
    }

    function login(){
        var reqJson = {requestMsg: {
                            email: $("#emailInput").val(),
                            password: $("#passwordInput").val()
            }};

        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/signin',
            data: JSON.stringify(reqJson),
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                $("#loginBtn").toggle();
                $("#logoutBtn").toggle();
                $("#signupBtn").toggle();
                $("#nicknameField").toggle();
                console.log(response);
                alert("로그인 성공");
                setUserNickname();
            },
            error: function (response) {
                console.log(response);
                alert("로그인 실패");
            }
        });
    }

    function logout(){
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/signout',
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                $("#loginBtn").toggle();
                $("#logoutBtn").toggle();
                $("#signupBtn").toggle();
                $("#nicknameField").toggle();
                alert("로그아웃 성공");
            },
            error: function (response) {
                alert("로그아웃 실패");
            }
        });
    }
</script>
</body>
</html>