<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>OrderSys登录界面</title>
  <script src=".//layui/layui.js"></script>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href=".//layui/css/layui.css" media="all">
  <link rel="stylesheet" href=".//style/admin.css" media="all">
  <link rel="stylesheet" href=".//style/login.css" media="all">
</head>
<body>

  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>中软国际</h2>
        <p>ChinaSoft-餐厅到店点餐系统</p>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="username" id="name" lay-verify="required" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="password" lay-verify="required" placeholder="密码" class="layui-input">
        </div>
        
        
        <div class="layui-form-item">
          <div class="layui-row">
            <div class="layui-col-xs7">
              <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
              <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
            </div>
            <div class="layui-col-xs5">
              <div style="margin-left: 10px;">
                <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
              </div>
            </div>
          </div>
        </div>
       
        
        
        <form action="" class="layui-form">
        <div class="layui-input-item">
        	<label class="layui-form-label">您的身份：</label>
      		<input type="radio" name="entity" value="管理员" title="餐厅管理员" >
      		<input type="radio" name="entity" value="服务员" title="服务员">
      		<input type="radio" name="entity" value="后厨" title="后厨">
    	</div>
    	</form>
        
        <div class="layui-form-item">
          <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit" id="login" onclick="login()">登 入</button>
        </div>
        
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>© 2022 <a href="https://www.chinasofti.com/" target="_blank">chinasofti.com</a></p>
      <p>
        <span><a href="http://www.chinasofti.com/admin/#get" target="_blank">获取授权</a></span>
        <span><a href="http://www.chinasofti.com/admin/pro/" target="_blank">在线演示</a></span>
        <span><a href="http://www.chinasofti.com/admin/" target="_blank">前往官网</a></span>
      </p>
    </div>
 
  </div>
  
  <script type="text/javascript">
  function login(){//处理ajax返回的js脚本
	  var userAccount=$('#name').val();//val()取值
	  var userPass=$('#password').val();
	  var entity=$('input[name="entity"]:checked').val();
	 
	 $.ajax({
		 type:'post', //get或者 post
		 url:'/Ordersys/CheckLoginServlet', //通讯地址
		 data:{'userAccount':userAccount,'userPass':userPass,'entity':entity}, //前端传后端（发送到服务器的数据）对象json方式传到url中；
		 dataType:'text', //后端传回来的数据的类型 text
		 success:function(res){//ajax回调函数
			 if(res=="success"){
				   if(entity=="管理员"){
				 alert("登录成功！！即将跳转到管理员主页！");
				 window.location.href="/Ordersys/ViewMainFormServlet";
			 }else if(entity=="服务员"){
				 alert("登录成功！！即将跳转到服务员主页！");
				 window.location.href="/Ordersys/ViewWaitFormServlet";
			 }else if(entity=="后厨"){
				 alert("登录成功！！即将跳转到后厨主页！");
				 window.location.href="/Ordersys/ViewCookerFormServlet";
			 }else{
				 alert("登录失败！");
			 }
		 }
		 }
	 });
	 
  }
  
  </script>
  
  <script>
  layui.use('form', function(){
	  var form = layui.form;
	  form.render();
  });
  </script>


</body>
</html>