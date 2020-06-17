package org.itstep.vinokurov.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.domain.Tnla;

public class TnlaListViewServlet extends HttpServlet{

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Tnla> tnlas = (List<Tnla>) req.getAttribute("tnlas");
		int pcTnlas = tnlas.size();
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>ТНПА</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table border=\"1\">");
		pw.println("<tr>");
		pw.println("<th>id</th>");
		pw.println("<th>Код ТНПА</th>");
		pw.println("<th>Наименование ТНПА</th>");
		pw.println("<th>Дата от</th>");
		pw.println("<th>Дата до</th>");
		pw.println("</tr>");
		for(Tnla tnla : tnlas) {
			pw.println("<tr>");
			pw.printf("<td>%d</td>", tnla.getId());
			pw.printf("<td>%s</td>", tnla.getCodTnla());
			pw.printf("<td>%s</td>", tnla.getNameTnla());
			pw.printf("<td>%1$td.%1$tm.%1$tY</td>", tnla.getDateStartTnla());
			pw.printf("<td>%1$td.%1$tm.%1$tY</td>", tnla.getDateEndTnla());
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.printf("<p>Всего ТНПА: %d</p>", pcTnlas);
		pw.println("</body>");
		pw.println("</html>");
	}
}
