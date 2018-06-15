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
            alert("로그인 성공");
            location.reload();
            // setUserNickname();
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
        url: '/user/signout',
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            // $("#loginBtn").toggle();
            // $("#logoutBtn").toggle();
            // $("#signupBtn").toggle();
            // $("#channelBtn").toggle();
            // $("#nicknameField").toggle();

            alert("로그아웃 성공");
            window.location.replace("/");
        },
        error: function (response) {
            alert("로그아웃 실패");
        }
    });
}