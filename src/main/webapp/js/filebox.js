$(document).ready(function(){
    var fileTarget = $('.filebox .upload-hidden');

    fileTarget.on('change', function(){
        if(window.FileReader){
            // 파일명 추출
            var filename = $(this)[0].files[0].name;
        }

        else {
            // Old IE 파일명 추출
            var filename = $(this).val().split('/').pop().split('\\').pop();
        };

        $(this).siblings('.upload-name').val(filename);
    });

    //preview image
    var imgTarget = $('.preview-image .upload-hidden');

    imgTarget.on('change', function(){
        var parent = $(this).parent();
        parent.children('.upload-display').remove();

        if(window.FileReader){
            //image 파일만
            if (!$(this)[0].files[0].type.match(/image\//)) return;

            var reader = new FileReader();
            reader.onload = function(e){
                var src = e.target.result;
                parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
            }
            reader.readAsDataURL($(this)[0].files[0]);
        }

        else {
            $(this)[0].select();
            $(this)[0].blur();
            var imgSrc = document.selection.createRange().text;
            parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

            var img = $(this).siblings('.upload-display').find('img');
            img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";
        }
    });
});

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

function getMyFile() {
    $.ajax({
        type: 'POST',
        url: '/channelfilebox/list',
        success: function (response) {
            var file = document.getElementById('file-table');
            var channelList = "";
            var fileIndex = 1;

            $.each(response.result, function (index, value) {

                file.innerHTML += "<tr>" +
                    " " + "<td>" + fileIndex + "</td>" +
                    " " + "<td class='file-name'>" + name + "</td>" +
                    " " + "<td>" + size + "</td>" +
                    " " + "<td> <button> Download </button> </td>" +
                    " " + "<td> <button> Delete </button> </td>" +
                    " " + "</tr>";
            });

            $(".conversation-wrap").append(channelList);

            alert("파일 불러오기 성공");
        },
        error: function (response) {
            alert("파일 불러오기 실패");
        }
    });
}

function createFilebox() {
    var reqJson = {
        requestMsg: {
            // id: $("#createChannelName").val(),
            // email: $("#createChannelPassword").val(),
            // file_path: $("#createChannelLmitCapacity").val(),
            // channel_name: $("#createChannelLmitTime").val(),
        }
    };

    console.log(reqJson);

    $.ajax({
        type: 'POST',
        url: '/channelfilebox/create',
        data: JSON.stringify(reqJson),
        async: false,
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            alert("파일 생성 성공");
            location.reload();
            // setUserNickname();
        },
        error: function (response) {
            console.log(response);
            alert("파일 생성 실패");
        }
    });
}