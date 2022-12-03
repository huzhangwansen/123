<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  
  <link rel="stylesheet" href="layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="layuiadmin/style/admin.css" media="all">
</head>
<body>

  <style>
  .layui-upload-img{width: 92px; height: 92px; margin: 0 10px 10px 0;}
  </style>

  <div class="layui-fluid"> 
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">头像上传</div>
          <div class="layui-card-body">
            <div class="layui-upload">
              <button type="button" class="layui-btn" id="test-upload-normal">上传头像</button>
              <div class="layui-upload-list">
                <img class="layui-upload-img" id="test-upload-normal-img">
                <p id="test-upload-demoText"></p>
              </div>
            </div> 
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src="layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: 'layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'upload'], function(){
    var $ = layui.jquery
    ,upload = layui.upload;
  
    //普通图片上传
    var uploadInst = upload.render({
      elem: '#test-upload-normal'
      ,url: ''
      ,before: function(obj){
        //预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result){
          $('#test-upload-normal-img').attr('src', result); //图片链接（base64）
        });
      }
    });
  });
  </script>
</body>
</html>