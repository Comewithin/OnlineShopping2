package com.homework02.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework02.jdbc.JDBC;

/**
 * Servlet implementation class Change_NumServlet
 */
@WebServlet("/Change_NumServlet")
public class Change_NumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change_NumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));//获取id
		int num = Integer.parseInt(request.getParameter("number"));//获取id
		
		int[] str = {id};
		
		if(JDBC.executeUpdate("update trolley set number = "+num+" where id = ?", str)!=0)
			pw.write("增加成功!");
		else pw.write("增加失败!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
