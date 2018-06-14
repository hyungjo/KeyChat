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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css">
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/myPage.js"></script>

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
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <% if(session.getAttribute("loginUser") != null) { %>
                <li class="nav-item" id="loginBtn">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Sign In</a>
                </li>
                <li class="nav-item" id="nicknameField" style="display: none;">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/myPage.jsp" id="nickname"><%=((UsersModel)session.getAttribute("loginUser")).getNickname()%></a>
                </li>
                <li class="nav-item" id="logoutBtn" style="display: none;">
                    <a class="nav-link" href="#" onclick="logout()">Sign Out</a>
                </li>
                <li class="nav-item" id="signupBtn">
                    <a class="nav-link" href="#">Sign Up</a>
                </li>
                <% } else { %>
                <li class="nav-item" id="loginBtn">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Sign In</a>
                </li>
                <li class="nav-item" id="nicknameField" style="display: none;">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/myPage.jsp" id="nickname"></a>
                </li>
                <li class="nav-item" id="logoutBtn" style="display: none;">
                    <a class="nav-link" href="#" onclick="logout()">Sign Out</a>
                </li>
                <li class="nav-item" id="signupBtn">
                    <a class="nav-link" href="#">Sign Up</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>