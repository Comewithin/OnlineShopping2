<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<link href="./css/trolley.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
//显示所选商品信息操作
function aonclick(id){
	window.location.href = "./Commodity_ChooseServlet?id="+id;
}

//删除商品操作
function donclick(id){
	//window.location.href = "./Commodity_ChooseServlet?id="+id;
	$.post("./Delete_TrolleyServlet",
			  {
			    id:id,
			  },
			  function(data,status){
			    alert(data/* + "\nStatus: " + status*/);
			    window.location.href = "./MyTrolleyServlet";
			  });
}
</script>
<script type="text/javascript">
//增加加入购物车的商品数
function add_onclick(id, number){
	//window.location.href = "./success.jsp";
	var num = number;
	num=num+1;
	//alert(num);
	$("#number").text(num);
	$.post("./Change_NumServlet",
			  {
			    id:id,
			    number:num,
			  },
			  function(data,status){
			    //alert(data);
			   window.location.href = "./MyTrolleyServlet";
			 });
}
//减少加入购物车的商品数
function minus_onclick(id, number){
	//window.location.href = "./success.jsp";
	var num1 = number;
	//alert(num);
	num1--;
	$("#number").text = num1;
	$.post("./Change_NumServlet",
			  {
			    id:id,
			    number:num1,
			  },
			  function(data,status){
			    //alert(data/* + "\nStatus: " + status*/);
			    window.location.href = "./MyTrolleyServlet";
			 //   $("#number").text(num);
			  });
}
</script>
<body style="text-align:center;">
     <h1>购物车列表</h1>
     <div style="width:100%;height:100%;">
     <table border="1" cellspacing="0" bordercolor="#F2F2F2" style="border-collapse:collapse;">
          <tr>
             <td width="100px" height="30px">商品名称</td>
             <td width="100px" height="30px">图片</td>
             <td width="100px" height="30px">商品信息</td>
             <td width="100px" height="30px">原价</td>
             <td width="100px" height="30px">现价</td>
             <td width="100px" height="30px">数量</td>
             <td width="100px" height="30px">操作</td>
          </tr>
          <c:forEach var="c" items="${list}">
              <tr>
                  <td  width="100px" height="30px" id="name">${c.name}</td>
                  <td width="100px" height="30px" id="img"><a href="#" onClick="aonclick(${c.id});"><img alt="图片找不到" src="./img/${c.img}"/></a></td>
                  <td width="100px" height="30px" id="message">${c.message}</td>
                  <td width="100px" height="30px" id="oldPrice">￥${c.oldPrice}</td>
                  <td width="100px" height="30px" id="newPrice" style="color:red;">￥${c.newPrice}</td>
                  <td width="100px" height="30px" >
                  <Button id="add" onClick="add_onclick(${c.id}, ${c.number});">+</Button>
                  <div id="number">${c.number}</div>
                  <Button id="minus" onClick="minus_onclick(${c.id}, ${c.number});">-</Button>
                  </td>
                  <td width="100px" height="30px">
                  <div><Button id="collect" onClick="conclick();">移入收藏</Button></div><br>
                  <div><Button id="delete" onClick="donclick(${c.id});">删除</Button></div>
                  </td>
              </tr>
          </c:forEach>
     </table>
 
     </div>
</body>
</html>