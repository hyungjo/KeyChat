<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <!------ Include the above in your HEAD tag ---------->
    <link rel="stylesheet" href="Chat.css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>채널</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <nav class="navbar">
                        <form class="form-inline">
                            ${Channel}
                            <input class="form-control mr-sm-2" type="search" placeholder="검색하기" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                        </form>
                        <button type="button" class="btn btn-ligh" onclick="window.closed">X</button>
                    </nav>
                </div>
                <div class="panel-body">
                    <ul class="chat">
                        <li class="right clearfix"><span class="chat-img pull-left">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">익명1</strong> <small class="pull-right text-muted">
                                    <span class="glyphicon glyphicon-time"></span>오전 11:39</small>
                                </div>
                                <p>
                                    아아아아아아 이현민 바보 반장은 바보다.
                                </p>
                            </div>
                        </li>
                        <li class="left clearfix"><span class="chat-img pull-right">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>오전 11:40</small>
                                    <strong class="pull-right primary-font">나</strong>
                                </div>
                                <p>
                                    그렇다 이현민은 모자라다. 머리도 깨져있다.
                                </p>
                            </div>
                        </li>
                        <li class="right clearfix"><span class="chat-img pull-left">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">익명2</strong> <small class="pull-right text-muted">
                                    <span class="glyphicon glyphicon-time"></span>오전 11:39</small>
                                </div>
                                <p>
                                    또 그런 친구가 있나?
                                </p>
                            </div>
                        </li>
                        <li class="left clearfix"><span class="chat-img pull-right">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>오전 11:40</small>
                                    <strong class="pull-right primary-font">나</strong>
                                </div>
                                <p>
                                    그 옆에 응호도 만만치 않다.
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input id="btn-input" type="text" class="form-control input-sm" placeholder="메세지를 입력하세요" />
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat">보내기</button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>