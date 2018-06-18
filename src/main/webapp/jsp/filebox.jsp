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
<div class="filebox bs3-primary preview-image">
    <input type="text" class="upload-name" disabled="disabled" style="width: 200px;">

    <label for="input_file">업로드</label>
    <input type="file" id="input_file" class="upload-hidden">

    <button class="upload">올리기</button>
    <b> ※ exe는 올릴 수 없습니다. </b>
</div>

<table id="file-table">
    <tr>
        <th> # </th>
        <th> Name </th>
        <th> Size </th>
        <th> Modified </th>
        <th> Delete </th>
    </tr>

</table>

<script type="text/javascript" src="../js/filebox.js"> </script>
<script>
    var aaa;
    var sss;

    $('.upload').click(function(){
        if($('.upload-name').val() == 0){
            alert('파일을 올려주세요.');
        } else{
            if(aaa > 100){
                alert('파일 100MB 초과되었습니다. 그 이하인 파일을 올려주세요.');
            } else{
                add($('.upload-name').val(), aaa + sss);
                $('.upload-name').val('');
            }
        }
    });

    $('#input_file').change(function() {
        var iSize = ($("#input_file")[0].files[0].size / 1024);
        var size = "";
        if (iSize / 1024 > 1) {
            if (((iSize / 1024) / 1024) > 1) {
                iSize = (Math.round(((iSize / 1024) / 1024) * 100) / 100);
                size = "GB";

            } else {
                iSize = (Math.round((iSize / 1024) * 100) / 100);
                size = "MB";
            }
        } else {
            iSize = (Math.round(iSize * 100) / 100);
            size = "KB";
        }

        aaa = iSize;
        sss = size
    });


    function add(name, size){
        var file = document.getElementById('file-table');
        file.innerHTML += "<tr>" +
            " " + "<td> 1 </td>" +
            " " + "<td class='file-name'>" + name + "</td>" +
            " " + "<td>" + size + "</td>" +
            " " + "<td> <button onclick='download($('.file-name').text())'> Download </button> </td>" +
            " " + "<td> <button id='delete'> Delete </button> </td>" +
            " " + "</tr>";
    }
</script>
</body>
</html>
