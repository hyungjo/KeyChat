<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileBox.css">

    <title>KeyChat Service</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/channelfilebox/create" method="POST" enctype="multipart/form-data">
<input type="text" name="email" value="aaa@naver.com">
<input type="text" name="channel_name" value="자유">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading"><strong>Upload files</strong> <small> </small></div>
                <div class="panel-body">
                    <div class="input-group file-preview">
                        <input placeholder="" type="text" class="form-control file-preview-filename" disabled="disabled">
                        <!-- don't give a name === doesn't send on POST/GET -->
                        <span class="input-group-btn">
	                  <!-- file-preview-clear button -->
	                  <button type="reset" class="btn btn-default file-preview-clear" style="display:none;">
                  	<span class="glyphicon glyphicon-remove"></span> Clear </button>
                            <!-- file-preview-input -->
                    <div class="btn btn-default file-preview-input">
                  	<span class="glyphicon glyphicon-folder-open"></span> <span class="file_title">Browse</span>
                    <input type="file" accept="text/cfg" name="file"/>
                            <!-- rename it -->
                  </div>
                  <button type="submit" class="btn btn-labeled btn-primary">
                  <span class="btn-label"> <i class="glyphicon glyphicon-upload"></i> </span>Upload</button>
                  </span> </div>
                    <!-- /input-group image-preview [TO HERE]-->

                    <!-- Drop Zone -->

                    <div class="panel panel-default">
                        <div class="row clearfix">
                            <div class="col-md-12 column">
                                <table class="table table-bordered table-hover" id="tab_logic">
                                    <thead>
                                    <tr >
                                        <th class="text-center">
                                            File Name
                                        </th>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    </tr>
                                    <tr id='addr1'></tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
    <!— jQuery library —>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!— Popper JS —>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <!— Latest compiled JavaScript —>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>