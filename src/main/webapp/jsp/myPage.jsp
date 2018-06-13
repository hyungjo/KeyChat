<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css">

    <title>KeyChat Service</title>
</head>
<body onload="getUserInfo()">
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <h2>내 정보</h2>
                <hr class="colorgraph">
                <div class="form-group">
                    이메일 : <label id="email"></label>
                </div>
                <div class="form-group">
                    닉네임 : <input type="text" name="nickname" id="nickname" class="form-control input-lg" placeholder="닉네임" tabindex="3">
                </div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <div class="form-group"></div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-lg" placeholder="비밀번호" tabindex="5">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="비밀번호 재확인" tabindex="6">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="phone" id="phone" class="form-control input-lg" placeholder="핸드폰 번호 (-없이 작성)" tabindex="4">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="job">직업</label>
                    </div>
                    <select class="custom-select" id="job">
                        <option selected value="직업">직업</option>
                        <option value="무직">무직</option>
                        <option value="학생">학생</option>
                        <option value="회사원">회사원</option>
                    </select>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <input type="submit" id="change" value="변경" onclick="updateUserInfo()" class="btn btn-block btn-lg" tabindex="7">
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <input type="reset" value="취소" class="btn btn-block btn-lg">
                    </div>
                </div>
                <hr class="colorgraph">
                <div class="col-xs-12 col-md-6">
                    <input type="submit" value="회원탈퇴" class="btn btn-lg" tabindex="8">
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

<script>
    function getUserInfo() {
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/info',
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                $("#email").text(response.result.email);
                $("#nickname").val(response.result.nickname);
                $("#phone").val(response.result.phone);
                $("#job").filter(function() {
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
                email: $("#email").text(),
                password: $("#password").val(),
                nickname: $("#nickname").val(),
                job: $("#job option:selected").text(),
                phone: $("#phone").val()
            }};

        //POST 방식으로 url에 요청을 한다.
        //data에 url에 해당하는 JSON을 넣어 보낸다. (해당 컨트롤러 코드 보면 알 수 있음)
        //data는 문자열로 변환해서 보내야 하기때문에 JSON.stringify로 문자열로 변환하여 보낸다.
        //요청이 성공이면 success안의 함수를 실행하고 실패(입력 값 오류, 서버 내 오류 등과 같은)하면 error 안의 함수가 실행된다.
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/update',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(reqJson),
            success: function (response) {
                alert("수정 성공");
                console.log(response);
            },
            error: function (response) {
                alert("수정 실패");
                console.log(response);
            }
        });
    }
</script>
</body>
</html>