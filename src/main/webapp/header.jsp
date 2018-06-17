<%@ page import="com.keychat.dto.base.UsersModel" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/channels.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/myPage.js"></script>
    <script src="${pageContext.request.contextPath}/js/channels.js"></script>

    <title>KeyChat Service</title>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">KeyChat</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/about.jsp">About</a>
                </li>
                <% if(((UsersModel)session.getAttribute("loginUser")) != null) { %>
                <li class="nav-item" id="channelBtn">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/channels.jsp">Channels</a>
                </li>
                <li class="nav-item" id="nicknameField">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/myPage.jsp" id="nickname"><%=((UsersModel)session.getAttribute("loginUser")).getNickname()%></a>
                </li>
                <li class="nav-item" id="logoutBtn">
                    <a class="nav-link" href="#" onclick="logout()">Sign Out</a>
                </li>
                <% } else { %>
                <li class="nav-item" id="loginBtn">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Sign In</a>
                </li>
                <li class="nav-item" id="signupBtn">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/register.jsp">Sign Up</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>


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