<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所选商品信息显示</title>
</head>
<link href="./css/choose.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
//加入购物车操作
function jonclick(id){
	//window.location.href = "./Join_TrolleyServlet?id="+id;
		  $.post("./Join_TrolleyServlet",
		  {
		    id:id,
		  },
		  function(data,status){
		    alert(data/* + "\nStatus: " + status*/);
		  });
}

//我的购物车操作
function tonclick(){
	window.location.href = "./MyTrolleyServlet";
}
</script>

<body>

<div>
      <c:forEach var="c" items="${list}">

       <div style="width:100%;height:100%;">
	       <div class="a">
	           <table border="1" cellspacing="0" bordercolor="#F2F2F2" style="border-collapse:collapse;">
	               <tr><td style="width:240px;height:240px;"><img alt="" src="./img/${c.img}"/></td></tr>
	           </table>
	       </div>
	       
	       <div class="b"><h5><img alt="" src="./img/new.jpg"/>${c.message}</h5></div><br>
	       
	       <div class="c">
			       <div>原价：<span class="d">￥${c.oldPrice}</span></div>
			       <div>现价：<span class="e">￥${c.newPrice}</span></div>
			       <div>库存：<span class="f">${c.inventory}</span></div>
			       <div style="float:left;"><Button id="join" onClick="jonclick(${c.id});">加入购物车</Button></div>
                   <div style="float:left;margin-left:50px;"><Button id="trolley" onClick="tonclick();">我的购物车</Button></div>
	       </div>
	       
       </div>
       
       
       
       
      </c:forEach>
</div>  
</body>
</html>