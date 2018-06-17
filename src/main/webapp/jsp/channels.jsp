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
                    <span class="input-group-text" id="">새 채널 생성</span>
                </div>
                <input type="text" class="form-control" placeholder="Search ... ">
            </div>

            <table style="width: 100%" border="1" id="channel_table">
                <tr class="tr">
                    <td class="num" rowspan="2"> 1 </td>
                    <td class="channel-title"> Naimish Sakhpara </td>
                </tr>
                <tr class="td">
                    <td class="channel-leader"> Hello </td>
                </tr>
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
                    <input class="form-control input-lg" id="channel-search" type="text" onkeyup="myFunction()">
                </div>
                <div class="alert alert-success" role="alert">
                    <h4 class="alert-heading">Hot 태그</h4>
                    #음식 #운동  #
                    <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
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
                                    <th>#</th>
                                    <th>Name <i class="fa fa-sort"></i></th>
                                    <th>Address</th>
                                    <th>City <i class="fa fa-sort"></i></th>
                                    <th>Pin Code</th>
                                    <th>Country <i class="fa fa-sort"></i></th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Thomas Hardy</td>
                                    <td>89 Chiaroscuro Rd.</td>
                                    <td>Portland</td>
                                    <td>97219</td>
                                    <td>USA</td>
                                    <td>
                                        <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Maria Anders</td>
                                    <td>Obere Str. 57</td>
                                    <td>Berlin</td>
                                    <td>12209</td>
                                    <td>Germany</td>
                                    <td>
                                        <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Fran Wilson</td>
                                    <td>C/ Araquil, 67</td>
                                    <td>Madrid</td>
                                    <td>28023</td>
                                    <td>Spain</td>
                                    <td>
                                        <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>Dominique Perrier</td>
                                    <td>25, rue Lauriston</td>
                                    <td>Paris</td>
                                    <td>75016</td>
                                    <td>France</td>
                                    <td>
                                        <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>Martin Blank</td>
                                    <td>Via Monte Bianco 34</td>
                                    <td>Turin</td>
                                    <td>10100</td>
                                    <td>Italy</td>
                                    <td>
                                        <a href="#" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
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
                        <div role="tabpanel" class="tab-pane" id="profile">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="/footer.jsp" flush="false"/>
<script type="text/javascript" src="http://johannburkard.de/resources/Johann/jquery.highlight-5.js"></script>
<script>
    $( document ).ready( function() {
        getMyChannel();
    });

    $('.form-control').keydown(function(event){
        if(event.which == 13){
            $('.media-heading').removeHighlight().highlight($('.form-control').val());
            // var result = $('.form-control').value;
            // var str = $('.media-heading')[result].childNodes[0].nodeValue;
            // //td[번호]를 읽어와 안의 값을 str에 저장
            // alert(str);
        }
    });

    function myFunction() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("channel-search");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
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
