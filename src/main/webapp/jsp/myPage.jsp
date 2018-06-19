<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>

<div class="container">
    <div class="row1">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <h2>내 정보</h2>
                <hr class="colorgraph">
                <div class="form-group">
                    이메일 : <label id="modiEmail"></label>
                </div>
                <div class="form-group">
                    닉네임 : <input type="text" name="nicknamefield" id="modiNickname" class="form-control input-lg" placeholder="닉네임" tabindex="3">
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="passwordfield" id="modiPassword" class="form-control input-lg" placeholder="비밀번호" tabindex="5">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmationfield" id="password_confirmation" class="form-control input-lg" placeholder="비밀번호 재확인" tabindex="6">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="phone" id="modiPhone" class="form-control input-lg" placeholder="핸드폰 번호 (-없이 작성)" tabindex="4">
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
                <form action = "/user/leave" method ="post">
                <div class="col-xs-12 col-md-6">
                    <input type="submit" value="회원탈퇴" class="btn btn-lg" tabindex="8">
                </div>
                </form>
        </div>
    </div>
</div>

<jsp:include page="/footer.jsp" flush="false"/>
<script>
    $( document ).ready( function() {
        getUserInfo();
    });
</script>