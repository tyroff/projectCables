package org.itstep.vinokurov.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.logic.LogicException;

public interface Action {
	Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException;
	
	public static class Result {
		private final String url;
		private final ResultType type;
		
		public Result(String url) {
			this(url, ResultType.REDIRECT);
		}
		
		public Result(String url, ResultType type) {
			this.url = url;
			this.type = type;
		}

		public String getUrl() {
			return url;
		}

		public ResultType getType() {
			return type;
		}
	}
	
	public static enum ResultType {
		FORWARD,
		REDIRECT
	}
}
