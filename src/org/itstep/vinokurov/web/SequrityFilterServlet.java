package org.itstep.vinokurov.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.domain.Role;
import org.itstep.vinokurov.domain.User;

public class SequrityFilterServlet implements Filter{
	
	private static Set<String> whiteURLs = new HashSet<>();
	static {
		whiteURLs.add("/");
		whiteURLs.add("/index.html");
		whiteURLs.add("/login.html");
	}
	
	private static Map<Role, Set<String>> accessUrl = new HashMap<>();
	static {
		Set<String> adminURLs = new HashSet<>();
		adminURLs.add("/workspace.html");
		accessUrl.put(Role.ADMIN, adminURLs);
		
		Set<String> technologistURLs = new HashSet<>();
		technologistURLs.add("/workspace.html");
		technologistURLs.add("/workspace/tnla.html");
		technologistURLs.add("/workspace/tnla/delegate.html");
		technologistURLs.add("/workspace/tnla/add.html");
		technologistURLs.add("/workspace/tnla/update.html");
		technologistURLs.add("/workspace/tnla/save.html");
		technologistURLs.add("/workspace/tnla/delete.html");
		technologistURLs.add("/workspace/tnla/deleteImplement.html");
		technologistURLs.add("/workspace/tnla/tnlaAndCableCategory.html");
		technologistURLs.add("/workspace/tnla/tnlaAndCableCategorySave.html");
		
		technologistURLs.add("/workspace/cableCategory.html");
		technologistURLs.add("/workspace/cableCategory/delegate.html");
		technologistURLs.add("/workspace/cableCategory/add.html");
		technologistURLs.add("/workspace/cableCategory/update.html");
		technologistURLs.add("/workspace/cableCategory/save.html");
 		technologistURLs.add("/workspace/cableCategory/delete.html");
		technologistURLs.add("/workspace/cableCategory/deleteImplement.html");
		
		technologistURLs.add("/workspace/brands.html");
		technologistURLs.add("/workspace/brands/delegate.html");
		technologistURLs.add("/workspace/brands/add.html");
		technologistURLs.add("/workspace/brands/update.html");
		technologistURLs.add("/workspace/brands/save.html");
 		technologistURLs.add("/workspace/brands/delete.html");
		technologistURLs.add("/workspace/brands/deleteImplement.html");
		accessUrl.put(Role.TECHNOLOGIST, technologistURLs);
		
		for(Set<String> userURLs : accessUrl.values()) {
			userURLs.add("/logout.html");
		}
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		boolean isAccess = false;
		if(!whiteURLs.contains(uri)) {
			HttpSession session = request.getSession(false);
			if(session != null) {
				User user = (User)session.getAttribute("userSession");
				if(user != null) {
					Set<String> urls = accessUrl.get(user.getRole());
					if(urls.contains(uri)) {
						isAccess = true;
					}
				}
			}
		} else {
			isAccess = true;
		}
		if(isAccess) {
			chain.doFilter(req, resp);
		} else {
			//TODO: it is need to delete!
			System.out.println(uri);
			//
			response.sendRedirect(request.getContextPath() + "/index.html?message=" + URLEncoder.encode(String.format("Доступ к [%s] запрещён!", uri), "UTF-8"));
			//TODO: it is need to creat a massage "Доступ запрещён для не авторизированным пользователям."
		}
	}
}
