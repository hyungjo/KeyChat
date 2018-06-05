<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="Search.css">
    <title>Insert title here</title>
</head>
<body>

<ul class="nav">
    <li>
        <div id="email_search" class="line">
            <h4>이메일 찾기</h4><p></p>
            <div >
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">닉네임</span>
                    </div>
                    <input type="text" class="form-control" id="validationTooltipUsername" placeholder="닉네임" aria-describedby="validationTooltipUsernamePrepend" required>
                    <div class="invalid-tooltip">닉네임을 입력하세요.</div>
                </div>
                &nbsp;
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">번호</span>
                    </div>
                    <input type="text" class="form-control" id="validationTooltipUsername" placeholder="핸드폰번호" aria-describedby="validationTooltipUsernamePrepend" required>
                    <div class="invalid-tooltip">핸드폰번호를 입력하세요.</div>
                </div>
                &nbsp;
            </div>
            <button class="btn btn-primary" type="submit">이메일찾기</button>
        </div>
    </li>
    <li>
        <div id="password_search" class="line">
            <h4>비밀번호 찾기</h4><p></p>
            <div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                    </div>
                    <input type="text" class="form-control" id="validationTooltipUsername" placeholder="이메일" aria-describedby="validationTooltipUsernamePrepend" required>
                    <div class="invalid-tooltip">이메일을 입력하세요.</div>
                </div>
                &nbsp;
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">번호</span>
                    </div>
                    <input type="text" class="form-control" id="validationTooltipUsername" placeholder="핸드폰번호" aria-describedby="validationTooltipUsernamePrepend" required>
                    <div class="invalid-tooltip">핸드폰번호를 입력하세요.</div>
                </div>
                &nbsp;
            </div>
            <button class="btn btn-primary" type="submit">비밀번호찾기</button>
        </div>
    </li>
</ul>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>