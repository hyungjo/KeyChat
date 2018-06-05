<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="MyPage.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form">
                <h2>내 정보</h2>
                <hr class="colorgraph">
                <div class="form-group">
                    이메일 :
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
                        <label class="input-group-text" for="inputGroupSelect01">직업</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01">
                        <option selected>직업</option>
                        <option value="1">무직</option>
                        <option value="2">학생</option>
                        <option value="3">회사원</option>
                    </select>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <input type="submit" id="change" value="변경" class="btn btn-block btn-lg" tabindex="7">
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <input type="reset" value="취소" class="btn btn-block btn-lg">
                    </div>
                </div>
                <hr class="colorgraph">
                <div class="col-xs-12 col-md-6">
                    <input type="submit" value="회원탈퇴" class="btn btn-lg" tabindex="8">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>