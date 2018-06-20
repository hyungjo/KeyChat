function getUserInfo() {
    $.ajax({
        type: 'POST',
        url: '/user/info',
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            $("#modiEmail").text(response.result.email);
            $("#modiNickname").val(response.result.nickname);
            $("#modiPhone").val(response.result.phone);
            $("#modiJob").filter(function() {
                return $(this).text() == response.result.job;
            }).prop('selected', true);
            console.log(response);
        },
        error: function (response) {
            console.log(response);
        }
    });
}

function updateUserInfo() {
    //입력 폼에서 사용자가 입력한 값을 가져와 JSON 형태로 만든다.
    //$("#입력폼의 id 값").text()는 태그와 태그 사이에 담긴 값
    //$("#입력폼의 id 값").val()는 태그 안에 담긴 값
    var reqJson = {requestMsg: {
            email: $("#modiEmail").text(),
            password: $("#modiPassword").val(),
            nickname: $("#modiNickname").val(),
            job: $("#modiJob option:selected").text(),
            phone: $("#modiPhone").val()
        }};

    //POST 방식으로 url에 요청을 한다.
    //data에 url에 해당하는 JSON을 넣어 보낸다. (해당 컨트롤러 코드 보면 알 수 있음)
    //data는 문자열로 변환해서 보내야 하기때문에 JSON.stringify로 문자열로 변환하여 보낸다.
    //요청이 성공이면 success안의 함수를 실행하고 실패(입력 값 오류, 서버 내 오류 등과 같은)하면 error 안의 함수가 실행된다.
    $.ajax({
        type: 'POST',
        url: '/user/update',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(reqJson),
        success: function (response) {
            alert("정보 수정을 성공하였습니다.");
            $("#modiEmail").text(response.result.email);
            $("#modiNickname").val(response.result.nickname);
            $("#modiPhone").val(response.result.phone);
            $("#modiJob").filter(function() {
                return $(this).text() == response.result.job;
            }).prop('selected', true);
            console.log(response);
        },
        error: function (response) {
            alert("정보 수정을 실패하였습니다.");
            console.log(response);
        }
    });
}

