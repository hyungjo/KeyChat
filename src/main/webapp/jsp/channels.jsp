<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="/header.jsp" flush="false"/>

<div class="container-fluid">
    <div class="row">
        <div class="conversation-wrap col-lg-3">
            <div class="form-group col-3">
                <p class="h4">내 채널</p>
            </div>
            <div class="input-group">
                <div class="input-group-prepend">
                    <button class="input-group-text" data-toggle="modal" data-target="#createChannelModal">새 채널 생성</button>
                </div>
                <input type="text" id="channel-search2" class="form-control" placeholder="Search ... ">
            </div>

            <table style="width: 100%" id="channel_table">
                <%--Will Add My Channel List--%>

                <%--My Channel List Format--%>
                <%--<tr class="tr1">--%>
                <%--<td class="num" rowspan="2"> 1 </td>--%>
                <%--<td class="channel-title"> Naimish Sakhpara </td>--%>
                <%--</tr>--%>
                <%--<tr class="tr2">--%>
                <%--<td class="channel-leader"> Hello </td>--%>
                <%--</tr>--%>
            </table>

            <%--<div class="media conversation">--%>
            <%--<a class="pull-left" href="#">--%>
            <%--<img class="media-object" data-src="holder.js/64x64" alt="64x64" style="width: 50px; height: 50px;"--%>
            <%--src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACqUlEQVR4Xu2Y60tiURTFl48STFJMwkQjUTDtixq+Av93P6iBJFTgg1JL8QWBGT4QfDX7gDIyNE3nEBO6D0Rh9+5z9rprr19dTa/XW2KHl4YFYAfwCHAG7HAGgkOQKcAUYAowBZgCO6wAY5AxyBhkDDIGdxgC/M8QY5AxyBhkDDIGGYM7rIAyBgeDAYrFIkajEYxGIwKBAA4PDzckpd+322243W54PJ5P5f6Omh9tqiTAfD5HNpuFVqvFyckJms0m9vf3EY/H1/u9vb0hn89jsVj8kwDfUfNviisJ8PLygru7O4TDYVgsFtDh9Xo9NBrNes9cLgeTybThgKenJ1SrVXGf1WoVDup2u4jFYhiPx1I1P7XVBxcoCVCr1UBfTqcTrVYLe3t7OD8/x/HxsdiOPqNGo9Eo0un02gHkBhJmuVzC7/fj5uYGXq8XZ2dnop5Mzf8iwMPDAxqNBmw2GxwOBx4fHzGdTpFMJkVzNB7UGAmSSqU2RoDmnETQ6XQiOyKRiHCOSk0ZEZQcUKlU8Pz8LA5vNptRr9eFCJQBFHq//szG5eWlGA1ywOnpqQhBapoWPfl+vw+fzweXyyU+U635VRGUBOh0OigUCggGg8IFK/teXV3h/v4ew+Hwj/OQU4gUq/w4ODgQrkkkEmKEVGp+tXm6XkkAOngmk4HBYBAjQA6gEKRmyOL05GnR99vbW9jtdjEGdP319bUIR8oA+pnG5OLiQoghU5OElFlKAtCGr6+vKJfLmEwm64aosd/XbDbbyIBSqSSeNKU+HXzlnFAohKOjI6maMs0rO0B20590n7IDflIzMmdhAfiNEL8R4jdC/EZIJj235R6mAFOAKcAUYApsS6LL9MEUYAowBZgCTAGZ9NyWe5gCTAGmAFOAKbAtiS7TB1Ng1ynwDkxRe58vH3FfAAAAAElFTkSuQmCC">--%>
            <%--</a>--%>
            <%--<div class="media-body">--%>
            <%--<h5 class="media-heading">Naimish Sakhpara</h5>--%>
            <%--<small>Hello</small>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>

        <div class="message-wrap col-lg-9">

            <div class="msg-wrap">

                <div class="form-group col-3">
                    <p class="h4">채널 검색</p>
                </div>
                <div class="form-group col-3">
                    <input class="form-control input-lg" id="channel-search1" type="text">
                </div>
                <div class="alert alert-secondary" role="alert">
                    <h4 class="alert-heading">HOT # Tags</h4>
                    <p class="mb-0">핫한 태그들이 나옵니다. 태그를 선택하시면 태그를 사용하는 방을 볼 수 있습니다.</p><br>
                    <div id="hothashtagslist" style="text-size:15px;">
                        <%--링크 기능 추가(누르면 검색 결과에 태그로 검색 되게--%>
                        <%--<a class="alert-link" href="#">News <span class="badge">5</span></a>--%>
                    </div>
                </div>
                <div class="table-wrapper">

                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="nav-item active">
                            <a href="#home" class="nav-link" aria-controls="home" role="tab" data-toggle="tab">채널 이름</a>
                        </li>
                        <li role="presentation" class="nav-item">
                            <a href="#profile" class="nav-link" aria-controls="profile" role="tab" data-toggle="tab">해시 태그</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <table class="table table-striped table-hover table-bordered" id="myTable">
                                <thead>
                                <tr>
                                    <th>Name <i class="fa fa-sort"></i></th>
                                    <th>Capacity <i class="fa fa-sort"></i></th>
                                    <th>Time</th>
                                    <th>Anonym <i class="fa fa-sort"></i></th>
                                    <th>Created</th>
                                </tr>
                                </thead>
                                <tbody id="channelsListRow">
                                <%--Will Add Channels List --%>
                                </tbody>
                            </table>
                            <div class="clearfix">
                                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                                <ul class="pagination">
                                    <li class="page-item disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
                                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                                    <li class="page-item"><a href="#" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">
                            <table class="table table-striped table-hover table-bordered" id="channelTable">
                                <thead>
                                <tr>
                                    <th>Name <i class="fa fa-sort"></i></th>
                                    <th>Tags <i class="fa fa-sort"></i></th>
                                </tr>
                                </thead>
                                <tbody id="channelsByTagsListRow">
                                <%--Will Add Channels List --%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- 채널 생성 Modal -->
    <div class="modal fade" id="createChannelModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <%--<div class="modal-header">--%>
                <%--<h5 class="modal-title" id="exampleModalLabel">로그인</h5>--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                <%--<span aria-hidden="true">&times;</span>--%>
                <%--</button>--%>
                <%--</div>--%>
                <div class="modal-body modal-form form-signin">
                    <form role="form" action="channel/create">
                        <h2> 채널 생성 </h2>
                        <hr class="colorgraph">
                        <div class="form-group">
                            <div class="col-xs-4">
                                <input type="text" name="createChannelName" id="createChannelName" class="form-control input-lg" placeholder="채널 이름" tabindex="1">
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="number" name="createChannelLmitCapacity" id="createChannelLmitCapacity" class="form-control input-lg" placeholder="최대 인원 (0 = 1000)" tabindex="3">
                        </div>
                        <div class="form-group">
                            <input type="number" name="createChannelLmitTime" id="createChannelLmitTime" class="form-control input-lg" placeholder="최대 시간 (0 = 무한)" tabindex="3">
                        </div>
                        <div class="form-group">
                            <input type="text" name="createChannelLmitAnonym" id="createChannelLmitAnonym" class="form-control input-lg" placeholder="익명(T / F)" tabindex="3">
                        </div>
                        <div class="form-group">
                            <input type="text" name="createChannelLmitHashtag" id="createChannelLmitHashtag" class="form-control input-lg" placeholder="해시태그(soccer, baseball, ...)" tabindex="3">
                        </div>
                        <div class="form-group">
                            <input type="password" name="createChannelPassword" id="createChannelPassword" class="form-control input-lg" placeholder="비밀번호" tabindex="5" onkeydown="if(event.keyCode==13) javascript:chkEnter();">
                        </div>

                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <input type="button" id="register" value="만들기" class="btn btn-block btn-lg" tabindex="7" onclick="createChannel()">
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <input type="reset" class="btn btn-block btn-lg" value="취소" data-dismiss="modal">
                            </div>
                        </div>
                    </form>
                </div>
                <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
                <%--<button type="button" class="btn btn-lg btn-block" data-dismiss="modal" onclick="login()">로그인</button>--%>
                <%--<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="login()">로그인</button>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>



    <jsp:include page="/footer.jsp" flush="false"/>
    <%--<script type="text/javascript" src="http://johannburkard.de/resources/Johann/jquery.highlight-5.js"></script>--%>
    <script>
        //태그 폼
        $("#createChannelLmitHashtag").tokenfield();

        $( document ).ready( function() {
            getMyChannel();
            getChannels();
            getChannelByHashtag();
            getHotHashtags();
        });

        $("#channel-search1").keyup(function (event){
            if(event.which==13) {
                myFunction1();
            }
        });

        $('#channel-search2').keyup(function(event){
            if(event.which==13) {
                myFunction2();
            }
        });

        $('#channel-search1').keyup(function(event){
            if(event.which==13) {
                myFunction3();
            }
        });
        
        function chkEnter() {
        	if (event.which || event.keyCode) {
        		if ((event.which == 13) || (event.keyCode == 13)) {
        			document.getElementById("register").click();
        			return false;
        		}
        	}else { 
        		return true;
        	}
        }

        function myFunction1() {
            var input, filter, table, tr, td, i;
            input = document.getElementById("channel-search1");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }

        }

        function myFunction2() {
            var input, filter, table, tr1, tr2, td, i;
            input = document.getElementById("channel-search2");
            filter = input.value.toUpperCase();
            table = document.getElementById("channel_table");
            tr1 = table.getElementsByClassName("tr1");
            tr2 = table.getElementsByClassName("tr2");
            for (i = 0; i < tr1.length; i++) {
                td = tr1[i].getElementsByTagName("td")[1];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr1[i].style.display = "";
                        tr2[i].style.display = "";
                    } else {
                        tr1[i].style.display = "none";
                        tr2[i].style.display = "none";
                    }
                }
            }
        }

        function myFunction3() {
            var input, filter, table, tr, td, i;
            input = document.getElementById("channel-search1");
            filter = input.value.toUpperCase();
            table = document.getElementById("channelTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[1];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }

    </script>
