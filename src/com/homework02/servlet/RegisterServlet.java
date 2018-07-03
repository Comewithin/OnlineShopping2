package com.homework02.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework02.service.PasswordMD5;
import com.homework02.service.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String username = new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");//用户名
		//String password = new String(PasswordMD5.md5Password(request.getParameter("pwd")).getBytes("iso-8859-1"),"utf-8");//密码,用MD5加密
		String realname = new String(request.getParameter("realname").getBytes("iso-8859-1"),"utf-8");//真实姓名
		String gender = new String(request.getParameter("gender").getBytes("iso-8859-1"),"utf-8");//性别
		String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");//详细地址
		String phone = request.getParameter("phone");//联系电话
		String password = PasswordMD5.md5Password(request.getParameter("pwd"));
		PrintWriter pw = response.getWriter();
		
		String[] str = {username, password, realname, gender, address, phone};
		
		if(!Register.isExist(phone)){
		
			//注册成功则跳转到登录页面
			if(Register.insert(str)!=0){
				pw.write("注册成功！");
				
			} else pw.write("注册失败！");
			
		} else pw.write("该用户已注册,请登录！");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
