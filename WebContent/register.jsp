<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.md5.js"></script>
<script language="JavaScript" src="./js/login.register.js"></script>
<link href="css/login_register.css" rel="stylesheet" type="text/css" /> 

<script type="text/javascript">
//MD5加密
function mdjia1(){
    var password=$("#pwd").val();
    if(password!=""){
    	var pwd=$.md5(password);
        //alert(pwd);
        $("#pwd").val(pwd);
    }
    
}

//MD5加密
function mdjia2(){
    var confirm_pwd=$("#confirm_pwd").val();
    if(confirm_pwd!=""){
	    var pwd=$.md5(confirm_pwd);
	    //alert(pwd);
	    $("#confirm_pwd").val(pwd);
    }
}
</script>

<body>

<nav>
    <img src="img/logo.png" height="60" width="170" alt="">
    <div>欢迎注册</div>
    <span>已有账号 ? <span><a href="./login.jsp">请登录</a></span></span>
</nav>

<div id="web">  
    <form  method="post">
        <div class="title">欢迎注册京东商城账号</div>
        <div class="form_item">
            <label>用  户  名</label>  
            <input type="text" value="" placeholder="请输入您的账户名和登录名" id="uname" name="uname" />  
        </div>  
        <div class="input-tip">  
            <span id="uname_error"></span>  
        </div> 
         
        <div class="form_item">  
            <label>设 置 密 码</label>  
            <input type="password" value="" placeholder="建议至少使用两种字符组合" id="pwd" name="pwd" onblur="mdjia1()" />  
        </div>  
        <div class="input-tip">  
            <span id="pwd_error"></span>  
        </div>  
        
        <div class="form_item">
            <label>确 认 密 码</label>
            <input type="password" value="" placeholder="请再次输入密码" id="confirm_pwd" name="confirm_pwd"  onblur="mdjia2()" />  
        </div>  
        <div class="input-tip">
            <span id="confirm_pwd_error"></span>
        </div>
        
        <div class="form_item">
            <label>真实姓名</label>
            <input type="text" value="" placeholder="请输入您的真实姓名" id="realname" name="realname" />
        </div>
        <div class="input-tip">  
            <span id="realname_error"></span>  
        </div> 
        
        <div class="form_item">  
            <label>性别</label>
            <input type="text" value="" placeholder="请输入您的性别" id="gender" name="gender" />
        </div>
        <div class="input-tip">  
            <span id="gender_error"></span>  
        </div> 
        
        <div class="form_item">  
            <label>中国 + 86</label>  
            <input type="text" value="" placeholder="请输入您的手机号码" id="phone" name="phone" />  
        </div>  
        <div class="input-tip">  
            <span id="phone_error"></span>  
        </div>  
        
        <div class="form_item">  
            <label>详细地址</label>  
            <input type="text" value="" placeholder="请输入您的详细地址" id="address" name="address" />  
        </div>
        <div class="input-tip">
            <span id="address_error"></span>
        </div>  
        
        <div class="form_item">  
            <label>验  证  码</label>  
            <input type="text" value="" placeholder="请输入验证码" id="code"/> 
            <label class="code"></label>  
        </div>  
        <div class="input-tip">  
            <span id="code_error"></span>  
        </div> 
         
        <div style="color:#333; font-size:12px">  
            <input type="checkbox" name="agree" id="agree"/>  
            我已阅读并同意  
            <a style="color: #38f">《京东商城用户注册协议》</a>  
        </div>  
        <div class="input-tip">  
            <span></span>  
        </div>  
        
        <input type="button" name="btn" id="btn" value="立即注册">  
        <div class="input-tip">  
            <span></span>
        </div>  
    </form>  
</div>  

</body>
</html>