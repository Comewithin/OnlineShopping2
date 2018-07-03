<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.md5.js"></script>
<script language="JavaScript" src="./js/login.register.js"></script>
<link href="css/login_register.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
//在提交到后台前用MD5加密一次
function mdjia1(){
    var password=$("#pwd").val();
    if(password!=""){
    	var pwd=$.md5(password);
        //alert(pwd);
        $("#pwd").val(pwd);
    }
    
}
</script>

<body style="text-align:center;">

<nav>
    <img src="img/logo.png" height="60" width="170" alt="">
    <div>欢迎登录</div>
    <span>没有账号 ? <span><a href="./register.jsp">请注册</a></span></span>
</nav>

<div id="web">  
    <form method="post">  
        <div class="title">欢迎登录京东商城</div>
        
        <div class="form_item">  
            <label>账号</label>
            <input type="text" value="" placeholder="请输入您的手机号码" id="phone" name="phone" />
        </div>
        <div class="input-tip">  
            <span id="phone_error"></span>  
        </div> 
        
        <div class="form_item">  
            <label>密码</label>
            <input type="password" value="" placeholder="请输入您的账号密码" id="pwd" name="pwd" onblur="mdjia1()" />
        </div>
        <div class="input-tip">  
            <span id="pwd_error"></span>  
        </div>
        
        <div class="form_item">  
            <label>验  证  码</label>  
            <input type="text" value="" placeholder="请输入验证码" id="code"/> 
            <label class="code"></label>
        </div>  
        <div class="input-tip">
            <span id="code_error"></span>
        </div> 
        
        <button type="button" name="lbtn" id="lbtn">登录</button>
    </form>  
</div>
</body>
</html>