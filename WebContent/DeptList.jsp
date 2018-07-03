<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DeptList</title>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	function toPage(pageIndex,type)
	{
		//alert(type);
		$("#pageIndex").attr("value",pageIndex);
	    $("#deptform").attr("action", "${pageContext.servletContext.contextPath}/PageServlet?type="+type);
		$("#deptform").submit();
	}
	
	function pagerJump(type)
	{
		var page_size=$('#pager_jump_page_size').val();
			
			var regu = /^[1-9]\d*$/;
				
			if (!regu.test(page_size)|| page_size < 1 || page_size > ${pageModel.totalPageSum})
			{
				alert('请输入[1-'+ ${pageModel.totalPageSum} +']之间的页码！');	
			}else
			{
	 		    $("#pageIndex").attr("value",page_size);
		        $("#deptform").attr("action", "${pageContext.servletContext.contextPath}/PageServlet?type="+type);
		    	$("#deptform").submit();
			}
	}	
	</script>
<script type="text/javascript">
//显示所选商品信息操作
function aonclick(id){
	window.location.href = "./Commodity_ChooseServlet?id="+id;
}
</script>

<link href="./css/show.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="deptform" method="post" id="deptform"
		action="${pageContext.servletContext.contextPath}/PageServlet">
	<!-- 配置pageIndex的隐藏域 -->
	<input type="hidden" name="pageIndex" value="${pageModel.pageIndex}" id="pageIndex">
	<div>
     <%@include file="./bar.jsp"%>
	</div>
	<div class="show">
	          <c:forEach items="${deptList}" var="dept">
	              <div class="show_all">
	                    <a href="#" onClick="aonclick(${dept.id});"><img alt="" src="./img/${dept.img}" /></a>
	                    <div>
	                    <span style="color:#E9423C;font-size:1.5em;">￥${dept.newPrice}</span>
	                    <span><img alt="" src="./img/new.jpg"/></span>
	                    </div>
	                    <div class="message">${dept.message}</div>
	              </div>        
	          </c:forEach>
	</div>
<div class="page">
	<!-- 分页处理 -->
<table style="font-size:13px;width:100%;align:center;"
	class="yahoo">
	<tr>
		<td
			style='COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none'>
			总${pageModel.totalPageSum}页数&nbsp;&nbsp;总记录条数${pageModel.totalRecordSum}
			<span class='first'><a href='#'
						onClick="toPage(1,'${type}')">首页</a></span>
			<c:choose>
				<c:when test="${pageModel.pageIndex==1}">
					<span class='disabled'>上一页</span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a href='#' onClick="toPage(${i},'${type}')">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='current'><a href='#'
						onClick="toPage(${pageModel.pageIndex+1},'${type}')">下一页</a></span>
				</c:when>
				<c:when test="${pageModel.pageIndex==pageModel.totalPageSum}">
				
					<span class='current'><a href='#'
						onClick="toPage(${pageModel.pageIndex-1},'${type}')">上一页</a></span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a href='#' onClick="toPage(${i},'${type}')">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='disabled'>下一页</span>
				</c:when>
				<c:otherwise>
					<span class='current'><a href='#' onClick="toPage(${pageModel.pageIndex-1},'${type}')" >上一页</a></span>
					<c:forEach begin="1" end="${pageModel.totalPageSum}" var="i">
						<c:choose>
							<c:when test="${pageModel.pageIndex==i}">
								<span class='current'>${i}</span>
							</c:when>
							<c:otherwise>
								<a href='#' onClick="toPage(${i},'${type}')">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<span class='current'><a href='#'
						onClick="toPage(${pageModel.pageIndex+1},'${type}')">下一页</a></span>
				</c:otherwise>
			</c:choose> <span class='first'><a href='#'
						onClick="toPage(${pageModel.totalPageSum},'${type}')">尾页</a></span>&nbsp;跳转到&nbsp;&nbsp;<input
			style='text-align: center; BORDER-RIGHT: #aaaadd 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #aaaadd 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #aaaadd 1px solid; COLOR: #000099; PADDING-TOP: 2px; BORDER-BOTTOM: #aaaadd 1px solid; TEXT-DECORATION: none'
			type='text' size='2' id='pager_jump_page_size' /> &nbsp;<input
			type='button'
			style='text-align: center; BORDE R-RIGHT: #dedfde 1px solid; PADDING-RIGHT: 6px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #dedfde 1px solid; PADDING-LEFT: 6px; PADDING-BOTTOM: 2px; BORDER-LEFT: #dedfde 1px solid; COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; BORDER-BOTTOM: #dedfde 1px solid; TEXT-DECORATION: none'
			value='确定' id='pager_jump_btn' onClick="pagerJump('${type}')"/>
		</td>
	</tr>
</table>
</div>	
</form>
</body>
</html>