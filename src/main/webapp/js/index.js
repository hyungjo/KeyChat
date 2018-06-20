function login(){
    var reqJson = {requestMsg: {
            email: $("#emailInput").val(),
            password: $("#passwordInput").val()
        }};

    $.ajax({
        type: 'POST',
        url: '/user/signin',
        data: JSON.stringify(reqJson),
        async: false,
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            // $("#loginBtn").toggle();
            // $("#logoutBtn").toggle();
            // $("#signupBtn").toggle();
            // $("#channelBtn").toggle();
            // $("#nicknameField").toggle();
            console.log(response);
            location.href="/jsp/channels.jsp";
            // setUserNickname();
        },
        error: function (response) {
            console.log(response);
            alert("이메일 혹은 비밀번호가 틀렸습니다.");
        }
    });
}

function logout(){
    $.ajax({
        type: 'POST',
        url: '/user/signout',
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            // $("#loginBtn").toggle();
            // $("#logoutBtn").toggle();
            // $("#signupBtn").toggle();
            // $("#channelBtn").toggle();
            // $("#nicknameField").toggle();

            window.location.replace("/");
        },
        error: function (response) {
        }
    });
}