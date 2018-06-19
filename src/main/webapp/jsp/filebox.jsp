<%--
  Created by IntelliJ IDEA.
  User: keh_a
  Date: 2018-06-18
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title> 파일 업로드 예제 </title>
        <script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="../css/filebox.css">
    </head>
    <body>

        <form action="${pageContext.request.contextPath}/channelfilebox/create" method="post" enctype="multipart/form-data">
            <div class="filebox bs3-primary preview-image">

                <input type="text" class="upload-name" disabled="disabled" style="width: 200px;">

                <label for="input_file">업로드</label>
                <input type="file" id="input_file" class="upload-hidden" name="input_file">

                <button type="submit">올리기</button>
                <b> ※ exe는 올릴 수 없습니다. </b>
            </div>
        </form>
            <%--<input type="hidden" name="channel_name" value="<%=request.getAttribute("channelName")%>">--%>
        <table id="file-table">
            <tr>
                <th> # </th>
                <th> Name </th>
                <th> Size </th>
                <th> Email </th>
                <th> Delete </th>
            </tr>
        </table>
    </body>
</html>

<script type="text/javascript" src="../js/filebox.js"> </script>
<script>
    $( document ).ready( function() {
        getMyFile();
    });
</script>
</body>
</html>
