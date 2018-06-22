function getUsers() {
    $.ajax({
        type: 'POST',
        url: '/user/allUser',
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            var usersListRow = "";
            $.each(response.result, function (index, value) {
            	usersListRow += "<tr>\n" +
                    "            <td>" + index + "</td>\n" +
                    "            <td>" + value.email + "</td>\n" +
                    "            <td>" + value.nickname + "</td>\n" +
                    "            <td>" + value.phone + "</td>\n" +
                    "            </tr>";
            });
            $("#usersListRow").empty();
            $("#usersListRow").append(channelsListRow);
        },
        error: function (response) {
            alert("사용자를 불러오는데 실패하였습니다.");
        }
    });
}