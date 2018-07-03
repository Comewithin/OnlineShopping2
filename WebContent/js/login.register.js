$(function(){
    // 用户名正则表达式  
    var uname_reg = /^[\u4e00-\u9fa5]{4,20}$|^[\dA-Za-z_\-]{4,20}$/;  
    var uname_ok = false;  
    // 用户名输入框获取焦点  
    $("#uname").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#uname_error").css("color", "#c5c5c5");  
        $("#uname_error").html("支持中文, 字母, 数字, \"-\", \"_\", 的组合, 4-20个字符");  
    });  
    $("#uname").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入您的账户名和登录名");  
            $("#uname_error").html("");  
            uname_ok = false;  
        } else if ($(this).val().length < 4 || $(this).val().length > 20) {  
            // 长度不对  
            $("#uname_error").html("长度只能在4-20个字符之间");
            $("#uname_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            uname_ok = false;  
        } else if (!$(this).val().match(uname_reg)) {  
            // 有特殊字符  
            $("#uname_error").html("格式错误, 仅支持中文, 字母, 数字, \"-\", \"_\"的组合");  
            $("#uname_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            uname_ok = false;  
        } else {  
            uname_ok = true;  
        }  
    });  



    var pwd_reg = /^(?![A-Z]+$)(?![a-z]+$)(?!\d+$)(?![\W_]+$)\S{6,32}$/;  
    var pwd_ok = false;  
    // 密码输入框获取焦点  
    $("#pwd").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#pwd_error").css("color", "#c5c5c5");  
        $("#pwd_error").html("建议使用字母, 数字和符号两种及以上的组合, 6-32个字符");  
    });  
    $("#pwd").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "建议至少使用两种字符组合");  
            $("#pwd_error").html("");  
            pwd_ok = false;  
        } else if ($(this).val().length < 6 || $(this).val().length > 32) {  
            // 长度不对  
            $("#pwd_error").html("长度只能在6-32个字符之间");  
            $("#pwd_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            pwd_ok = false;  
        } else if (!$(this).val().match(pwd_reg)) {  
            // 不是两种及以上的组合  
            $("#pwd_error").html("有被盗风险, 建议使用字母, 数字和符号两种及以上组合");  
            $("#pwd_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            pwd_ok = false;  
        } else {  
            pwd_ok = true;  
        }  
    });   
    



    // 再次密码输入框获取焦点  
    var confirm_pwd_ok = false;  
    $("#confirm_pwd").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#confirm_pwd_error").css("color", "#c5c5c5");  
        $("#confirm_pwd_error").html("请再次输入密码");  
    });  
    $("#confirm_pwd").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请再次输入密码");  
            $("#confirm_pwd_error").html("");  
            confirm_pwd_ok = false;  
        } else if ($(this).val() != $("#pwd").val()) {  
            // 再次输入的密码不一致  
            $("#confirm_pwd_error").html("两次输入的密码不一致");  
            $("#confirm_pwd_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            confirm_pwd_ok = false;  
        } else {  
            confirm_pwd_ok = true;  
        }  
    });   


    
    // 用户真实姓名正则表达式  
    var realname_reg = /^[\u2E80-\u9FFF]+$/;  
    var realname_ok = false;  
    // 用户真实姓名输入框获取焦点  
    $("#realname").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#realname_error").css("color", "#c5c5c5");  
        $("#realname_error").html("支持中文2-15个字符");  
    });  
    $("#realname").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入您的真实姓名");  
            $("#realname_error").html("");  
            realname_ok = false;  
        } else if ($(this).val().length < 2 || $(this).val().length > 15) {  
            // 长度不对  
            $("#realname_error").html("长度只能在2-15个字符之间");  
            $("#realname_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            realname_ok = false;  
        } else if (!$(this).val().match(realname_reg)) {  
            // 有特殊字符  
            $("#realname_error").html("格式错误, 仅支持中文组合");  
            $("#realname_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            realname_ok = false;  
        } else {  
        	realname_ok = true;
        }  
    });  



    // 用户性别正则表达式  
    var gender_reg = /^['男'|'女']$/;  
    var gender_ok = false;  
    // 用户性别输入框获取焦点  
    $("#gender").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#gender_error").css("color", "#c5c5c5");  
        $("#gender_error").html("输入“男”或“女”");  
    });  
    $("#gender").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入您的性别");  
            $("#gender_error").html("");
            gender_ok = false;   
        } else if (!$(this).val().match(gender_reg)) {  
            // 有特殊字符  
            $("#gender_error").html("请输入“男”或“女”");
            $("#gender_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            gender_ok = false;  
        } else {  
        	gender_ok = true;
        }  
    });  



    // 手机号码输入框获取焦点  
    var phone_reg = /^1[3|4|5|7|8]\d{9}$/;  
    var phone_ok = false;  
    $("#phone").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#phone_error").css("color", "#c5c5c5");  
        $("#phone_error").html("验证完成后, 可以使用该手机登录和找回密码,一个手机号码只能注册一次");  
    });  
    $("#phone").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入您的手机号码");  
            $("#phone_error").html("");  
            phone_ok = false;
        } else if ($(this).val().length != 11) {  
            // 长度不对  
            $("#phone_error").html("格式有错");  
            $("#phone_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            phone_ok = false;  
        } else if (!$(this).val().match(phone_reg)) {  
            // 输入的不是手机号码  
            $("#phone_error").html("格式有错");  
            $("#phone_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            phone_ok = false;  
        } else {  
            phone_ok = true;  
        }  
    });




    // 用户地址正则表达式  
    var address_reg = /^(?=.*?[\u4E00-\u9FA5])[\dA-Za-z\u4E00-\u9FA5]+/;  
    var address_ok = false;  
    // 用户地址输入框获取焦点  
    $("#address").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#address_error").css("color", "#c5c5c5");  
        $("#address_error").html("仅支持中文, 字母, 数字的组合");  
    });  
    $("#address").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入您的详细地址");  
            $("#address_error").html("");  
            address_ok = false;  
        } else if (!$(this).val().match(address_reg)) {  
            // 有特殊字符  
            $("#address_error").html("格式错误");  
            $("#address_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            address_ok = false;  
        } else {  
        	address_ok = true; 
        }  
    });  

 
  
    // 二维数组, 用于生成随机验证码  
    var array = [["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"], ["0", "1", "2", "3", "4", "6", "7", "8", "9"]];  
    var str = "";  
    randomCode();  
  
    // 点击更换验证码  
    $(".code").click(function(){  
        randomCode();  
    });  
    
    // 随机生成验证码  
    function randomCode(){  
        str = "";  
        for (var i = 0; i < 4; i++) {  
  
            // 随机生成一个下标  
            var temp = Math.random();  
            temp = temp < 0.5 ? Math.floor(temp) : Math.ceil(temp);  
  
            var length = array[temp].length;  
            //从任意值开始至任意值:  
            //parseInt(Math.random() * (上限-下限+1) + 下限);  
            var index = parseInt(Math.random() * length);  
            str += array[temp][index];  
        }  
        $(".code").html(str);  
    } 



    // 验证码输入框获取焦点  
    var code_ok = false;  
    $("#code").focus(function(){  
        $(this).css("outline", "none");  
        $(this).attr("placeholder", "");  
        $(this).parent().css("border-color", "#999");  
        $("#code_error").css("color", "#c5c5c5");  
        $("#code_error").html("看不清? 点击更换验证码");  
    });  
    $("#code").blur(function(){  
        if ($(this).val() == "") {  
            $(this).attr("placeholder", "请输入验证码");  
            $("#code_error").html("");  
            code_ok = false;  
        } else if ($(this).val() != str) {  
            // 输入错误的验证码  
            $("#code_error").html("验证码输入错误");  
            $("#code_error").css("color", "red");  
            $(this).parent().css("border-color", "red");  
            code_ok = false;  
        } else {  
            code_ok = true;  
        }  
    });  



    // 是否同意协议  
	var agree_ok = false;
    $("#agree").click(function(){  
        //alert($("#agreen").att("checked"));  
        if ($(this).attr('checked')) {
            $(this).attr('checked', false);
            agree_ok = false;
        } else {  
            $(this).attr('checked', true);  
            agree_ok = true;
        }  
    });



    $("#btn").click(function() {
        /* Act on the event 
         *  $("#agree").attr('checked') && uname_ok && pwd_ok && confirm_pwd_ok && realname_ok && gender_ok && phone_ok && address_ok && code_ok
         * */  
        if (agree_ok && uname_ok && pwd_ok && confirm_pwd_ok && realname_ok && gender_ok && phone_ok && address_ok && code_ok) {  
        	//alert('信息输入完整');
        	$.get("./RegisterServlet",
      			  {
        		     uname:$("#uname").val(),
        		     pwd:$("#pwd").val(), 
        		     confirm:$("#confirm").val(), 
        		     realname:$("#realname").val(),
        		     gender:$("#gender").val(),
        		     phone:$("#phone").val(), 
        		     address:$("#address").val()
      			  },
      			  function(data,status){
      				alert(data);
      			    //alert(data/* + "\nStatus: " + status*/);
      			    window.location.href = "./login.jsp";
      			  }); 
        } else {  
            alert('信息输入不完整或输入有误, 请核对');  
            return false;  
        }  
    });
 
    
    
    $("#lbtn").click(function() {
        /* Act on the event */  
        if (phone_ok && pwd_ok && code_ok) {  
        	//alert('信息输入完整');
        	$.get("./LoginServlet",
      			  {
        		     pwd:$("#pwd").val(), 
        		     phone:$("#phone").val(), 
      			  },
      			  function(data,status){
      				alert(data);
      			    //alert(data + "\nStatus: " + status);
      				if(data=="登录成功！"){
      					
      					window.location.href = "./index.jsp";
      				}
	
      				else window.location.href = "./error.jsp";
      			  }); 
        } else {  
            alert('信息输入不完整或输入有误, 请核对！');
            return false;
        }  
    });
    
});