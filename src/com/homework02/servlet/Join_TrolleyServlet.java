package com.homework02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework02.service.Join_Trolley;

/**
 * Servlet implementation class Join_Trolley
 */
@WebServlet("/Join_TrolleyServlet")
public class Join_TrolleyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join_TrolleyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		PrintWriter pw = response.getWriter();
			
		int num = 1;//第一次加入购物车的某种商品数目
		
		int id = Integer.parseInt(request.getParameter("id"));//获取id
		
		int[] str1 = {id, num};//将id和num存进数组作为插入数据库的条件
		
		int[] str2 = {id};
				
		ArrayList<Integer> list = Join_Trolley.selectId();
		
		//判断客户所选商品库存是否为空
		if(Join_Trolley.isEmpty(str2))
		{
		
			//如果list集合中（trolley表中）不存在此id，则执行更插入操作
			if(!list.contains(id)){
				
				 if(Join_Trolley.insert(str1)!=0){
					 pw.write("加入购物车成功！");
					 
				 } else pw.write("加入购物车失败！");
				 
			} else {
				//如果list集合中（trolley表中）存在此id，则执行更新number操作
			    if(Join_Trolley.update(str2)!=0){
				    pw.write("加入购物车成功！");
				     
			    } else pw.write("加入购物车失败！");
			}
			
	    } else pw.write("万分抱歉，该商品已卖完！");
			 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
