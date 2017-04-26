package com.kingteller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kingteller.bean.Location;
import com.kingteller.factory.BasicFactory;
import com.kingteller.service.LocationService;

/**
 * Servlet implementation class UploadLocationServlet
 */
@WebServlet("/UploadLocation")
public class UploadLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocationService service = BasicFactory.getFactory().getService(LocationService.class);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		
		int id = service.findAllLocation().size() + 1;
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8") ;
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8") ;
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");
		String city = new String(request.getParameter("city").getBytes("ISO-8859-1"),"utf-8") ;
		boolean uploadSuccess =  service.uploadLocation(new Location(id,address,name,Double.valueOf(lat),Double.valueOf(lng),city));
		String jsonStr ;
		if (uploadSuccess) {
			jsonStr = gson.toJson("yes");
		}else {
			jsonStr = gson.toJson("no");
		}
		PrintWriter out = null;
		try {
		    out = response.getWriter();
		    out.write(jsonStr);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
