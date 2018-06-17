<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="${pageContext.request.contextPath}/channel/create">
                <h2> 채널 생성 </h2>
                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="email" id="email" class="form-control input-lg" placeholder="이메일" tabindex="1">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <button type="button" class="btn" data-color="info" tabindex="2">중복</button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="nickname" id="nickname" class="form-control input-lg" placeholder="닉네임" tabindex="3">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group"></div>
                    </div>
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
                        <input type="submit" id="register" value="회원가입" class="btn btn-block btn-lg" tabindex="7">
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <a href="#" id="login" class="btn btn-block btn-lg">로그인</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="/footer.jsp" flush="false"/>