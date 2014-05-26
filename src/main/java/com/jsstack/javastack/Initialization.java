package com.jsstack.javastack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Initialization extends HttpServlet {

	private static final long serialVersionUID = 2688772084125050440L;

	@Override
	public void init() throws ServletException {
		Main.initAll();
	}
}
