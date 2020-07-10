package org.itstep.vinokurov.web;

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
		pw.print("<p style=\"color: green\">start_testSERVLET</p>");
		pw.print("<ul>");
		pw.print("<li><a href=\"workspace.html\">Workspace</a></li>");
		pw.print("</ul>");
	}

}
