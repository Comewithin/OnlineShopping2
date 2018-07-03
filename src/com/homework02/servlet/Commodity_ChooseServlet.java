package com.homework02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework02.service.Commodity_Choose;

/**
 * Servlet implementation class Commodity_ChooseServlet
 */
@WebServlet("/Commodity_ChooseServlet")
public class Commodity_ChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commodity_ChooseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取id
		int[] id = {Integer.parseInt(request.getParameter("id"))};
		
		//向前端传送数据
		request.setAttribute("list", Commodity_Choose.selectAll(id));
		//转发到另一个页面
		request.getRequestDispatcher("./commodity_choose.jsp").forward(request, response);
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
