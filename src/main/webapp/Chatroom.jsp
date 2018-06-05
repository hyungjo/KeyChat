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
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<head>
    <title>Insert title here</title>
    <style>
        #back {
            width: 30%;
            height: 500px;
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
            height: 20px;
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

        div#contents{
            margin-top: 10px;
        }
    </style>
</head>
<body>
닉네임 :
<input id="username" style="width: 10%;" type="text" />
<input type="submit" value="connect" onclick="onOpen('message');" /> <br>
<div id="back">
    <div id="title">
        <h2> 대화 창</h2>
    </div>
    <div id="content-box">
        <div id="contents">

        </div>
    </div>
    <input id="inputMessage" style="width: 65%;" type="text"/>
    <input id="mybtn" type="submit" value="send" onclick="send();" />
    <input type="submit" value="close" onclick="closeSocket();" />
</div>
<script>
    var socket = new WebSocket("ws://192.168.236.71:9999/chat");

    var p = document.getElementById("contents");
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
        var jsonObj = {"user1" : user, "close" : "님이 방에 나갔습니다."};
        socket.send(JSON.stringify(jsonObj));
        socket.close();
    }

    function onMessage(event){
        var jsonObj = JSON.parse(event.data);
        if(jsonObj.user != null && jsonObj.message != null && jsonObj.time != null){
            p.innerHTML += "<span style='padding-top: 15px; font-weight: bold; font-size: 18px'>"+jsonObj.user+"</span> <br/>"
            p.innerHTML += "<span style='1px solid write; border-radius: 5px; background-color: aquamarine;'>"+ jsonObj.message +"</span> <br/>"
            p.innerHTML += "<span>" + jsonObj.time + "</span> <br/>"
        }

        if(jsonObj.close != null){
            p.innerHTML += "<div style='text-align: center; background-color: bisque'>" + jsonObj.user1 + jsonObj.close + "</div> <br/>"
        }

        if(jsonObj.con != null){
            p.innerHTML += "<div style='text-align: center; background-color: bisque'>" + jsonObj.user2 + jsonObj.con + "</div> <br/>"
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

        if(msg1 != ""){
            var jsonObj = {"user" : user, "message" : msg1, "time" : str_time};
            p.innerHTML += "<span style='float: right; border: 1px solid white; border-radius: 5px; background-color: aquamarine;'>"+ msg1 +"</span> <br/>"
            p.innerHTML += "<span style='float: right;'>" + str_time + "</span> <br/>"
            socket.send(JSON.stringify(jsonObj));
            inputMessage.value = "";
        }
        inputMessage.focus();

        var box = document.getElementById("content-box");
        box.scrollTop = box.scrollHeight;
    }
</script>
</body>
</html>
