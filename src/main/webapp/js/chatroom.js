var socket = new WebSocket("ws://localhost:9999/chat");

var p = document.getElementById("contents");
//var nick = document.getElementById("nickname");

var sendmessage = document.getElementById("inputMessage");

sendmessage.addEventListener("keyup", function(event){
    event.preventDefault();

    if(event.keyCode == 13){
        document.getElementById("btn-chat").click();
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