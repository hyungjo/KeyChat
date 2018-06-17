<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form role="form" action="channel/create">
                <h2> 채널 생성 </h2>
                <hr class="colorgraph">
                    <div class="form-group">
                        <div class="col-xs-4">
                           <input type="text" name="name" id="name" class="form-control input-lg" placeholder="채널 이름" tabindex="1">
                         </div>
                    </div>
                        <div class="form-group">
                            <input type="number" name="limitCapacity" id="nickname" class="form-control input-lg" placeholder="최대 인원" tabindex="3">
                        </div>
                        <div class="form-group">
                        	<input type="checkbox" onselect="show(password)">
                            <input type="password" style="display:none" name="password" id="password" class="form-control input-lg" placeholder="비밀번호" tabindex="5">
                        </div>
                <div class="form-group">
                    <input type="text" name="phone" id="phone" class="form-control input-lg" placeholder="핸드폰 번호 (-없이 작성)" tabindex="4">
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <input type="submit" id="register" value="만들기" class="btn btn-block btn-lg" tabindex="7">
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <input type="reset" class="btn btn-block btn-lg" value="취소">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="/footer.jsp" flush="false"/>