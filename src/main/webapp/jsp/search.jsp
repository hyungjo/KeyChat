<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>

<div class="container" style="min-height: 735px; padding-top: 80px; padding-bottom: 0px;">
<table style="width: 100%;">
<tr>
    <td>
        <div id="email_search" class="line">
            <h4>이메일 찾기</h4><p></p>
            <form action="/user/forgotEmail" method="POST" accept-charset="UTF-8">
            <div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">닉네임</span>
                    </div>
                    <input type="text" class="form-control" name="nickname" placeholder="닉네임" aria-describedby="validationTooltipUsernamePrepend" required="">
                </div>
                &nbsp;
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">번호</span>
                    </div>
                    <input type="text" class="form-control" name="phone" placeholder="핸드폰번호" aria-describedby="validationTooltipUsernamePrepend" required="">
                </div>
                &nbsp;
            </div>
            <button class="btn" id="ebt" type="submit">이메일찾기</button></form>
        </div>
    </td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
    <td><form action="/user/forgotPassword" method="POST" accept-charset="UTF-8">
        <div id="password_search" class="line">
            <h4>비밀번호 찾기</h4><p></p>
            <div>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                    </div>
                    <input type="text" class="form-control" name="email" placeholder="이메일" aria-describedby="validationTooltipUsernamePrepend" required="">
                </div>
                &nbsp;
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="validationTooltipUsernamePrepend">번호</span>
                    </div>
                    <input type="text" class="form-control" name="phone" placeholder="핸드폰번호" aria-describedby="validationTooltipUsernamePrepend" required="">
                </div>
                &nbsp;
            </div>
            <button class="btn" id="pbt" type="submit">비밀번호찾기</button>
        </div></form>
    </td>
</tr>
</table>
</div>

<jsp:include page="/footer.jsp" flush="false"/>