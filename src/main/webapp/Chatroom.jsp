<%--
  Created by IntelliJ IDEA.
  User: keh_a
  Date: 2018-06-05
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <!--
    <style>
        #wrapper{
            position: absolute;
            padding: 10px;
            top: 10px;
            left: 50%;
            margin-left: -680px;
            overflow: hidden;
        }

        #content{
            width: 450px;
            float: left;
            padding: 10px;
        }

        #sidebar{
            width: 200px;
            height: 567px;
            float: left;
            padding: 10px;
            margin-top: 45px;
            overflow: auto;
            background-color: antiquewhite;
        }

        table caption{
            font-weight: bold;
            height: 50px;
            margin-bottom: 15px;
            line-height: 3.3;
            background-color: white;
        }

        td{
            padding-top: 5px;
            font-size: 20px;
            font-weight: bold;
        }

        #back {
            width: 450px;
            height: 600px;
            background-color: antiquewhite;
        }

        #title {
            padding-top: 5px;
        }

        h2 {
            text-align: center
        }

        #content-box{
            height: 75%;
            background-color: white;
            margin-left: 10px;
            margin-right: 10px;
            padding-left: 20px;
            padding-right: 20px;
            overflow: auto;
        }

        .inputmessage{
            width: 60%;
            height: 30px;
            margin-top: 10px;
            margin-left: 10px;
        }

        .sendbtn{

            margin-left: 20px;
            margin-top: 1px;
            margin-right: 2px;
        }

        input#username, input#inputMessage{
            margin-top: 10px;
            margin-left: 10px;
        }

        div#contents {
            margin-top: 10px;
        }
    </style>
    -->
    <!--
    <style>
        #title{
            font-size: 16px;
            font-weight: bold;
            margin-right: 15px;
        }

        .panel-footer{
            margin-top: 65px;

        }

        #btn-chat{
            width: 75px;
            height: 50px;
        }

        .panel{
            height: 590px;
        }

        #back {
            width: 450px;
            height: 700px;
        }

        #content-box{
            height: 75%;
            background-color: azure;
            margin-left: 10px;
            margin-right: 10px;
            padding-left: 20px;
            padding-right: 20px;
            overflow: auto;
        }
    </style>
    -->
    <link rel="stylesheet" href="css/chatroom.css">
</head>
<body>
<!--
    <div id="wrapper">
        <div id="content">
            <div>
                <input id="username" style="width: 20%;" type="text"/>
                <input type="submit" value="connect" onclick="onOpen('message');">
            </div>
            <div id="back">
                <div id="title">
                    <h2> 대화 창</h2>
                </div>
                <div id="content-box">
                    <div id="contents">

                    </div>
                </div>
                <input id="inputMessage" style="width: 30%;" type="text"/>
                <input id="mybtn" type="submit" value="send" onclick="send();" />
                <input type="submit" value="close" onclick="closeSocket();" />
            </div>
        </div>

        <div id="sidebar">
            <table style="width: 200px">
                <caption>
                    ● 채널 참여자 ●
                </caption>
            </table>
            <div id="nickname">

            </div>
        </div>
    </div>
-->
<div class="container">
    <div class="row">
        <div id="col-md-5">
            <div class="panel">
                <div class="panel-heading">
                    <div id="dd">
                        <br>
                        <input id="username" style="width: 20%;" type="text"/>
                        <input id="channelName" style="width: 20%;" type="text" value="a"/>
                        <input type="button" value="소켓 연결" onclick="chatInit();">
                        <input id="con" type="submit" value="connect" onclick="onOpen('message');">
                        <div id="aaa"> </div> <br>
                    </div>
                    <nav class="navbar">
                        <div id="title">
                            채널 이름
                        </div>
                        <input id="Search" class="form-control mr-sm-2" type="search" placeholder="검색하기" aria-label="Search">
                        <button id="btn_search" class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                        <button type="button" class="btn btn-ligh" onclick="closeSocket();">X</button>
                    </nav>
                </div>
                <div id="back">
                    <div id="content-box">
                        <div id="message-box">

                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="input-group">
                    <input id="inputMessage" type="text" class="form-control input-sm" placeholder="메세지를 입력하세요" />
                    <span class="input-group-btn">
                        <button class="btn btn-warning btn-sm" id="btn-chat" onclick="send();">보내기</button>
                    </span>
                </div>
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
<script type="text/javascript" src="http://johannburkard.de/resources/Johann/jquery.highlight-5.js"></script>
<script type="text/javascript" src="js/chatroom.js"></script>
</body>
</html>
