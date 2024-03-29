package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.IWordDao;
import com.dao.WordDaoImpl;
import com.model.Word;

/**
 * Servlet implementation class FenleiServlet
 */
@WebServlet("/FenleiServlet")
public class FenleiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenleiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//*[@id="main"]/div/div[2]/div[1]/div[2]/div/a
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin","*");
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		
		JSONObject json = new JSONObject();
		List<JSONObject> data = new ArrayList<>();
		List<Word> words = new ArrayList<>();
		IWordDao dao = new WordDaoImpl();
		words = dao.allWords1(type);
		for(Word word:words) {
			JSONObject wordi = new JSONObject();
			wordi.put("name",word.getName());
			wordi.put("expl",word.getExpl());
			data.add(wordi);
		}
		json.put("data", data);
		//System.out.println(json);
		//System.out.println(type);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toJSONString());
	}

}
