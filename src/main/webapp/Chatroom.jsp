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
                    <div>
                        <br>
                        닉네임 : <input id="username" style="width: 20%;" type="text"/>
                        <input type="submit" value="connect" onclick="onOpen('message');">
                    </div>
                    <nav class="navbar">
                        <form class="form-inline">
                            <div id="title">
                                채널 이름
                            </div>
                            <input class="form-control mr-sm-2" type="search" placeholder="검색하기" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                        </form>
                        <button type="button" class="btn btn-ligh" onclick="window.closed">X</button>
                    </nav>
                </div>
                <div id="back">
                    <div id="content-box">
                        <div id="contents">

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
<script>
    var socket = new WebSocket("ws://localhost:9999/chat");

    var p = document.getElementById("contents");
    //var nick = document.getElementById("nickname");

    var sendmessage = document.getElementById("inputMessage");

    sendmessage.addEventListener("keyup", function(event){
        event.preventDefault();

        if(event.keyCode == 13){
            document.getElementById("mybtn").click();
        }
    });

    socket.onerror = function(message){
        onError(message);
    }

    socket.onmessage = function(message){
        onMessage(message);
    }

    function closeSocket(){
        var user = document.getElementById("username").value.trim();
        if(user){
            var jsonObj = {"user1" : user, "close" : "님이 방에 나갔습니다."};
            socket.send(JSON.stringify(jsonObj));
        }
        socket.close();
    }

    function onMessage(event){


        var jsonObj = JSON.parse(event.data);
        if(jsonObj.user != null && jsonObj.message != null && jsonObj.time != null){
            p.innerHTML += "<div style='font-weight: bold; font-size: 18px'>"+jsonObj.user+"</div> <br/>"
            p.innerHTML += "<div style='float: left; 1px solid white; border-radius: 15px; background-color: aquamarine; padding: 8px; margin-top: -15px; margin-left: -5px'>"+ jsonObj.message +"</div>"
            p.innerHTML += "<div style='margin-top: 26px; margin-bottom: 10px;'>" + jsonObj.time + "</div>"
        }

        if(jsonObj.close != null){
            p.innerHTML += "<div style='text-align: center; background-color: bisque'>" + jsonObj.user1 + jsonObj.close + "</div> <br/>"
        }

        if(jsonObj.con != null){
            p.innerHTML += "<div style='text-align: center; background-color: bisque'>" + jsonObj.user2 + jsonObj.con + "</div> <br/>"
            //nick.innerHTML += "<tr> <td>" + jsonObj.user2 + "</td> </tr> <br>";
        }

        var box = document.getElementById("content-box");
        box.scrollTop = box.scrollHeight;
    }

    function onError(event){
        alert("연결 에러");
    }

    function onOpen(event){
        var user = document.getElementById("username").value.trim();

        if(user == ""){
            alert("닉네임을 입력해주세요.");
        }
        else{
            //nick.innerHTML += "<tr> <td>" + user + "</td> </tr> <br>";
            var jsonObj = {"user2" : user, "con" : "님이 접속했습니다."};
            socket.send(JSON.stringify(jsonObj));
        }
    }

    function send(){
        var user = document.getElementById("username").value.trim();
        var sendmessage = document.getElementById("inputMessage");
        var msg1 = sendmessage.value.trim();
        var day = new Date();

        var hour = day.getHours();
        var min = day.getMinutes();

        var str_time = hour + "시 " + min +"분";

        if(user == ""){
            alert('닉네임을 입력해주세요.');
            inputMessage.value = "";
        } else{
            if(msg1 != ""){
                var jsonObj = {"user" : user, "message" : msg1, "time" : str_time};
                p.innerHTML += "<div style='text-align: right; float: right; 1px solid white; border-radius: 15px; background-color: aquamarine; padding: 8px;'>" + msg1 + "</div> <br/>"
                p.innerHTML += "<div style='text-align: right; margin-top: 20px'>" + str_time + "</div> <br/>"
                socket.send(JSON.stringify(jsonObj));
                inputMessage.value = "";
            }
            inputMessage.focus();
        }

        var box = document.getElementById("content-box");
        box.scrollTop = box.scrollHeight;
    }
</script>
</body>
</html>
