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
    $('.upload').click(function(){
        if($('.upload-name').val() == 0){
            alert('파일을 올려주세요.');
        } else{
            if(file_ss() == "exe"){
                alert('exe는 올릴 수 없습니다.');
            }
            else{
                var size = file_size();
                if(size == false){
                    alert('100MB 파일 초과되었습니다. 그 이하 파일으로 올려주세요.');
                }
                if(size){
                    add($('.upload-name').val(), size);
                    $('.upload-name').val('');
                }
            }
        }
    });

    function download(data){
        alert(data);
    }

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

    function file_size(){
        if(window.ActiveXObject){
            var fso = new ActiveXObject("Scripting.FileSystemObject");
            var filepath = document.getElementById('input_file').value; // input 아이디 "file1"
            var thefile = fso.getFile(filepath);
            sizeinbytes = thefile.size;
        }else{
            sizeinbytes = document.getElementById('input_file').files[0].size;
        }
        var fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
        var fSize = sizeinbytes;
        var i=0;
        while(fSize>900){
            fSize/=1024;
            i++;
        }
        if(fSize > 101.58542346954346){
            return false;
        }
        else{
            fSize = (Math.round(fSize*100)/100)+' '+fSExt[i];
            return fSize;
        }

//                if(fSize > 102400){
//                    alert('첨부하신 용량이 100MB 넘습니다. 그 이하 파일을 선택해주세요.');
//                } else{
//                    fSize = (Math.round(fSize*100)/100)+' '+fSExt[i];
//                    return fSize;
//                }
    }

    function file_ss(){
        var thumbext = document.getElementById('input_file').value; //파일을 추가한 input 박스의 값
        thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase(); //파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.
        return thumbext;
    }
</script>
</body>
</html>
