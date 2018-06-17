var openWin = window.open("./Chatroom.jsp",
    "childForm", "width=570, height=350, resizable = yes, scrollbars = yes");
}

function getMyChannel(){
    $.ajax({
        type: 'POST',
        url: '/channel/me',
        success: function (response) {
            var table = document.getElementById('channel_table');
            var channelList = "";
            $.each(response.result, function(index, value){
                table.innerHTML += "<tr class='tr1'>"
                    + " " + "<td class='num' rowspan='2'> 1 </td>"
                    + " " + "<td class='channel-title'>" + value.name + "</td>"
                    + " " + "</tr>"
                    + " " + "<tr class='tr2'>"
                    + " " + "<td class='channel-leader'>" + value.leader + "</td>"
                    + " " + "</tr>";

                // channelList += "<table style='width: 100%' border='1'>";
                // channelList += "<tr class='tr1'>";
                // channelList += "<td class='num' rowspan='2'> 1 </td>";
                // channelList += "<td class='channel-title'>" + value.name;+" </td>";
                // channelList += "</tr>";
                // channelList += "<tr class='tr2'>";
                // channelList += "<td class='channel-leader'>" + value.leader + "</td>";
                // channelList += "</tr>";
                // channelList += "</table>";
            });

            $(".conversation-wrap").append(channelList);

            alert("내 채널 불러오기 성공");
        },
        error: function (response) {
            alert("내 채널 불러오기 실패");
        }
    });
}