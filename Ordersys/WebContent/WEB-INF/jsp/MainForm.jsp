<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>餐厅管理员主界面</title>
  <link rel="stylesheet" href=".//layui/css/layui.css">
 
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">管理员界面</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
   
    <ul class="layui-nav layui-layout-right">
  
      <li class="layui-nav-item"><a href="LoginServlet">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">主要功能</a>
          <dl class="layui-nav-child">
          <dd><a href="/Ordersys/face1.jsp">头像</a></dd>
            <dd><a href="/Ordersys/allwaiter.html">员工管理</a></dd>
            <dd><a href="/Ordersys/addwaiter.html">添加员工</a></dd>
            <dd><a href="/Ordersys/alldishes.html">菜品管理</a></dd> 
            <dd><a href="/Ordersys/adddishes.html">菜品添加</a></dd> 
            <dd><a href="/Ordersys/addnotice.html">实时公告发布</a></dd>
            <dd><a href="/Ordersys/allmon.html">订单详情</a></dd>
            <dd><a href="/Ordersys/goodsbuy.html">订单结账与取消</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
   <!--  <div style="padding: 15px;">内容主体区域</div> -->
   <iframe src="" id="main" height="100%" width="100%"> </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src=".//layui/layui.js"></script>
<script>
 //监听
 layui.use('element', function(){
  var element = layui.element;
  var $=layui.jquery;
  $(document).ready(function() {
	  $("dd>a").click(function (e) {
		e.preventDefault();
		 $('#main').attr("src",$(this).attr("href")); 
	});
	
});
  
});  

</script>
</body>
</html>

