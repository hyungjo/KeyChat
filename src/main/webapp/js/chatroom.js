var socket;
function chatInit(){
    var channelName = $("#channelRoom").val();
    socket = new WebSocket("ws://58.127.165.240:9999/chat/" + channelName);

    socket.onerror = function(message){
        onError(message);
    }

    socket.onmessage = function(message){
        onMessage(message);
    }
}

var a = document.getElementById("aaa");
var p = document.getElementById("message-box");

var sendmessage = document.getElementById("inputMessage");

sendmessage.addEventListener("keyup", function(event){
    event.preventDefault();

    if(event.keyCode == 13){
        document.getElementById("btn-chat").click();
    }
});



$('#Search').keydown(function(event){
    if(event.which == 13){
        $('#btn_search').click();
    }
});

$('#btn_search').click(function(){
    // $('.mess').removeHighlight().highlight($('#Search').val());
})

function closeSocket(){
    var user = document.getElementById("username").value.trim();
    if(user){
        var jsonObj = {"user1" : user, "close" : "님이 방에 나갔습니다."};
        socket.send(JSON.stringify(jsonObj));
        a.style.display = 'none';
    }
    socket.close();
}

function onMessage(event){


    var jsonObj = JSON.parse(event.data);
    if(jsonObj.user != null && jsonObj.message != null && jsonObj.time != null){
        p.innerHTML += "<div id='chat-user'>" + jsonObj.user + "</div> <br/>";
        p.innerHTML += "<div id='chat-user-message' class='mess'>" + jsonObj.message + "</div>";
        p.innerHTML += "<div id='chat-user-time'>" + jsonObj.time + "</div>";
    }

    if(jsonObj.close != null){
        p.innerHTML += "<div id='chat-close'>" + jsonObj.user1 + jsonObj.close + "</div> <br/>"
    }

    if(jsonObj.con != null){
        p.innerHTML += "<div id='chat-con'>" + jsonObj.user2 + jsonObj.con + "</div> <br/>"
        // nick.innerHTML += "<tr> <td>" + jsonObj.user2 + "</td> </tr> <br>";
    }

    var box = document.getElementById("content-box");
    box.scrollTop = box.scrollHeight;
}

function onError(event){
    alert("연결 에러");
}

function onOpen(event){
    var user = document.getElementById("username").value.trim();
    var user2 = document.getElementById("username");
    var btn_con = document.getElementById("con");

    if(user == ""){
        alert("닉네임을 입력해주세요.");
    }
    else{
        //nick.innerHTML += "<tr> <td>" + user + "</td> </tr> <br>";
        var jsonObj = {"user2" : user, "con" : "님이 접속했습니다."};
        user2.style.display = 'none';
        a.innerHTML += user + "님이 접속하셨습니다.";
        btn_con.style.display='none';
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
            p.innerHTML += "<div id='chat-me-message' class='mess'>" + msg1 + "</div> <br/>";
            p.innerHTML += "<div id='chat-me-time'>" + str_time + "</div> <br/>";
            socket.send(JSON.stringify(jsonObj));
            createChatHistory(msg1);
            inputMessage.value = "";
        }
        inputMessage.focus();
    }

    var box = document.getElementById("content-box");
    box.scrollTop = box.scrollHeight;
}

function isAuthUser(){
    var inputPassword = $("#channelPasswordField").val();
    var reqJson = {requestMsg: {
            channelName: $("#channelRoom").val(), //값을 못가져옴 화면이 로딩되기 전이기 때문
            password: inputPassword
        }};

    $.ajax({
        type: 'POST',
        url: '/channel/auth',
        data: JSON.stringify(reqJson),
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            alert("채널 인증 성공");
            $("#channelPasswordModal").modal('hide');
        },
        error: function (response) {
            alert("채널 인증 실패");
        }
    });
}

function createChatHistory(msg){
    var reqJson = {requestMsg: {
            email: $("#useremail").val(),
            channel_name: $("#channelRoom").val(), //값을 못가져옴 화면이 로딩되기 전이기 때문
            contents: msg
        }};
    console.log("createChatHistory: ");
    console.log(reqJson);
    $.ajax({
        type: 'POST',
        url: '/chathistory/create',
        data: JSON.stringify(reqJson),
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            console.log(response.result.contents);
        },
        error: function (response) {
            console.log(response);
            alert("채팅 메시지 DB 입력 에러");
        }
    });
}