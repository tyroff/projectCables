package org.itstep.vinokurov.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		PrintWriter pw = resp.getWriter();
		pw.print("<p style=\"color: green\">start_SERVLET</p>");
		pw.print("<ul>");
		pw.print("<li><a href=\"workspace/tnla/list.html\">TNLAs list</a></li>");
		pw.print("</ul>");
	}

}