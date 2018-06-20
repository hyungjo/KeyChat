<%@ page import="com.keychat.dto.base.UsersModel" %><%--
  Created by IntelliJ IDEA.
  User: keh_a
  Date: 2018-06-05
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/filebox.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/chatroom.css">
</head>
<body>
<%--채팅 및 접속자 정보--%>
<input type="hidden" id="channelRoom" value="<%=request.getAttribute("channelName")%>"/>
<input type="hidden" id="username"
       value="<%=((UsersModel)(session.getAttribute("loginUser"))).getNickname()%>"/>
<input type="hidden" id="useremail"
       value="<%=((UsersModel)(session.getAttribute("loginUser"))).getEmail()%>"/>
<%--채팅 및 접속자 정보 끝--%>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="panel">
                <div class="panel-heading">
                </div>
                <div id="back">
                    <div id="content-box">
                        <nav class="navbar">
                            <div id="title">
                                Chat
                            </div>
                            <input id="Search" class="form-control mr-sm-2" type="search" placeholder="검색하기"
                                   aria-label="Search">
                            <button id="btn_search" class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                            <button type="button" class="btn btn-ligh" onclick="closeSocket();">X</button>
                        </nav>
                        <div id="message-box">

                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input id="inputMessage" type="text" class="form-control input-sm" placeholder="메세지를 입력하세요"/>
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat" onclick="send();">보내기</button>
                        </span>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-2">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#channelInfo" role="tab"
                       aria-controls="channelInfo">채널 정보</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#recommend" role="tab" aria-controls="recommend">추천
                        서비스</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#schedule" role="tab" aria-controls="schedule">일정
                        관리/메모</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#filebox" role="tab" aria-controls="filebox">파일방</a>
                </li>
            </ul>
        </div>
        <div class="col">
            <div class="tab-content">
                <div class="tab-pane active" id="channelInfo" role="tabpanel">
                    <h3>채널 정보</h3>
                    <div class="row">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>채널 명:</td>
                                <td id="">Programming</td>
                            </tr>
                            <tr>
                                <td>최대 참여자 수</td>
                                <td>06/23/2013</td>
                            </tr>
                            <tr>
                                <td>최대 유지 시간</td>
                                <td>01/24/1988</td>
                            </tr>
                            <tr>
                                <td>익명 여부</td>
                                <td>Female</td>
                            </tr>
                            <tr>
                                <td>채널 생성 시간</td>
                                <td>Kathmandu,Nepal</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <h3>참여자 정보</h3>
                </div>
                <div class="tab-pane" id="recommend" role="tabpanel">
                    <div style="text-align: center;">
                        <input type="button" class="btn one" onclick="startRealTimeLAResult()" value="실시간 분석 시작">
                        <input type="button" class="btn btn-danger" onclick="stopRealTimeLAResult()" value="실시간 분석 중지">
                    </div>
                    <table id="key">
                        <tr>
                            <th colspan="5" style="text-align: center"><h5><strong>&#60;주요 키워드&#62;</strong></h5></th>
                        </tr>
                        <tr>
                            <td colspan="5" id="aa"><a id="bb">키워드를 클릭하시면 자동검색 페이지가 나옵니다.</a><br>&nbsp;</td>
                        </tr>
                        <tr class="keyword" id = "keywordList">
                        </tr>
                        <tr><th>&nbsp;</th></tr>
                        <tr class="entity" id = "entityList">
                        </tr>
                        <tr><td colspan="5">&nbsp;<hr style="size:5px;">&nbsp;</td></tr>
                        <tr>
                            <th colspan="5" style="text-align: center"><h5><strong>&#60;대화 주제 TOP3&#62;</strong></h5></th>
                        </tr>
                        <tr id="category">
                            <th colspan="5"><div id="graph_category"></div></th>
                        </tr>
                    </table>
                </div>
                <div class="tab-pane" id="schedule" role="tabpanel">
                    <h3>일정 관리 / 메모</h3>
                    <div class="row">

                    </div>
                </div>
                <div class="tab-pane" id="filebox" role="tabpanel">
                    <h3>파일 박스</h3>
                    <div class="row">
                        <form id="fileUploadForm">
                            <div class="filebox bs3-primary preview-image">

                                <input type="text" class="upload-name" disabled="disabled" style="width: 200px;">

                                <label for="input_file">업로드</label>
                                <input type="file" id="input_file" name="input_file">

                                <input type="button" onclick="fileUpload()" value="올리기"/>
                                <b> ※ exe는 올릴 수 없습니다. </b>
                            </div>
                        </form>
                        <table id="file-table">
                            <tr>
                                <th> #</th>
                                <th> Name</th>
                                <th> Size</th>
                                <th> Email</th>
                                <th> Delete</th>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--ChannelPasswordModal--%>
<div class="modal fade" id="channelPasswordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                <h4 class="modal-title" id="exampleModalLabel">채널 비밀번호</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="channelPasswordField" class="control-label">비밀번호 입력:</label>
                        <input type="password" class="form-control" id="channelPasswordField" onkeydown="if(event.keyCode==13) javascript:chkEnter();">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                <button type="button" id="enterbtn" class="btn btn-primary" onclick="isAuthUser()">확인</button>
            </div>
        </div>
    </div>
</div>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/chatroom.js"></script>
<script>
    var realTimeResultUpdate;

    function startRealTimeLAResult() {
        realTimeResultUpdate = setInterval(function () {
            getNLAResultByCount();
            getTotalNLAResult();
        }, 10 * 1000);
        // getTotalNLAResult();
    }
    
    function chkEnter() {
    	if (event.which || event.keyCode) {
    		if ((event.which == 13) || (event.keyCode == 13)) {
    			document.getElementById("enterbtn").click();
    			return false;
    		}
    	}else { 
    		return true;
    	}
    }

    function stopRealTimeLAResult() {
        clearInterval(realTimeResultUpdate);
    }

    function getNLAResultByCount() {
        var reqJson = {
            requestMsg: {
                channelName: $("#channelRoom").val(), //값을 못가져옴 화면이 로딩되기 전이기 때문
                count: 50
            }
        };

        $.ajax({
            type: 'POST',
            url: '/channelKeywordRecom/analyzeContents',
            data: JSON.stringify(reqJson),
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response);

            },
            error: function (response) {
            }
        });

    }

    //실시간 그래프
    function getTotalNLAResult() {
        var reqJson = {
            requestMsg: {
                channelName: $("#channelRoom").val(), //값을 못가져옴 화면이 로딩되기 전이기 때문
                count: 3
            }
        };

        $.ajax({
            type: 'POST',
            url: '/channelKeywordRecom/list',
            data: JSON.stringify(reqJson),
            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                //표 안망가지게 전체 td 출력
                console.log(response);
                var keywordList = "";
                $.each(response.result.keyword, function (index, value) {
                    keywordList += "<td><a id='keywords2' target=\"_blank\"  href=\'https://www.google.co.kr/search?q=" + value +  "\'>" + value + "</a></td>";
                });
                $("#keywordList").empty();
                $("#keywordList").append(keywordList);

                var entityList = "";
                $.each(response.result.entity, function (index, value) {
                    entityList += "<td><a id='keywords2' target=\"_blank\"  href=\'https://www.google.co.kr/search?q=" + value +  "\'>" + value + "</a></td>";
                });
                $("#entityList").empty();
                $("#entityList").append(entityList);


                $("#graph_category").empty();
                var category = [];
                $.each(response.result.category, function (index, value) {
                    category.push({label: value[0], value: value[1]});
                });

                Morris.Donut({
                    element: 'graph_category',
                    data: category,
                    resize: true
                }).redraw();

            },
            error: function (response) {
            }
        });
    }

    function fileUpload() {
        var formData = new FormData();
        formData.append('file', $('#input_file')[0].files[0]);
        formData.append('channelRoom', $('#channelRoom').val());

        $.ajax({
            url : 'channelfilebox/create',
            type : 'POST',
            data : formData,
            async: false,
            cache: false,
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
            success : function(data) {
                alert("파일 업로드 성공");
            },
            error: function(response) {
                alert("파일 업로드 실패");
            }
        });
    }

    function noEvent() { // 새로 고침 방지
        if (event.keyCode == 116) {
            alert("새로고침을 할 수 없습니다.");
            event.keyCode = 2;
            return false;
        } else if (event.ctrlKey
            && (event.keyCode == 78 || event.keyCode == 82)) {
            return false;
        }
    }

    document.onkeydown = noEvent;

    $(document).ready(function () {
        //채널 접속
        chatInit();

        //비밀번호 입력
        $('#channelPasswordModal').modal({backdrop: 'static', keyboard: false});


    });

    $(function () {
        $('#Search').bind('keyup change', function (ev) {
            // pull in the new value
            var searchTerm = $(this).val();

            // remove any old highlighted terms
            $('.mess').removeHighlight();

            // disable highlighting if empty
            if (searchTerm) {
                // highlight the new term
                $('.mess').highlight(searchTerm);
            }
        });
    });

    jQuery.fn.highlight = function (pat) {
        function innerHighlight(node, pat) {
            var skip = 0;
            if (node.nodeType == 3) {
                var pos = node.data.toUpperCase().indexOf(pat);
                if (pos >= 0) {
                    var spannode = document.createElement('span');
                    spannode.className = 'highlight';
                    var middlebit = node.splitText(pos);
                    var endbit = middlebit.splitText(pat.length);
                    var middleclone = middlebit.cloneNode(true);
                    spannode.appendChild(middleclone);
                    middlebit.parentNode.replaceChild(spannode, middlebit);
                    skip = 1;
                }
            }
            else if (node.nodeType == 1 && node.childNodes && !/(script|style)/i.test(node.tagName)) {
                for (var i = 0; i < node.childNodes.length; ++i) {
                    i += innerHighlight(node.childNodes[i], pat);
                }
            }
            return skip;
        }

        return this.each(function () {
            innerHighlight(this, pat.toUpperCase());
        });
    };

    jQuery.fn.removeHighlight = function () {
        function newNormalize(node) {
            for (var i = 0, children = node.childNodes, nodeCount = children.length; i < nodeCount; i++) {
                var child = children[i];
                if (child.nodeType == 1) {
                    newNormalize(child);
                    continue;
                }
                if (child.nodeType != 3) {
                    continue;
                }
                var next = child.nextSibling;
                if (next == null || next.nodeType != 3) {
                    continue;
                }
                var combined_text = child.nodeValue + next.nodeValue;
                new_node = node.ownerDocument.createTextNode(combined_text);
                node.insertBefore(new_node, child);
                node.removeChild(child);
                node.removeChild(next);
                i--;
                nodeCount--;
            }
        }

        return this.find("span.highlight").each(function () {
            var thisParent = this.parentNode;
            thisParent.replaceChild(this.firstChild, this);
            newNormalize(thisParent);
        }).end();
    };
</script>
</body>
</html>
