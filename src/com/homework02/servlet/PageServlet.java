package com.homework02.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework02.bean.Commodity;
import com.homework02.bean.PageModel;
import com.homework02.service.Page;


/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageModel pageModel = new PageModel();
		String page_Index = request.getParameter("pageIndex");
		String type1 = request.getParameter("type");
		String[] type = {type1};
		if(page_Index==null||page_Index.equals("")) {
			page_Index = "1";
		}
		int pageIndex = Integer.parseInt(page_Index);
		pageModel.setPageIndex(pageIndex);
		pageModel.setTotalRecordSum(Page.queryCommodityCount(type));
		List<Commodity> list = Page.queryCommodity(pageModel,type);
		request.setAttribute("deptList", list);
		request.setAttribute("type", type1);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("/DeptList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
