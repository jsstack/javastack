package com.jsstack.javastack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.flywaydb.core.Flyway;

import com.jsstack.javastack.dao.DBHelper;

public class Initialization extends HttpServlet {

	private static final long serialVersionUID = 2688772084125050440L;

	@Override
	public void init() throws ServletException {
		Main.initAll();
		System.out.println("=============================================Migrating...");
		Flyway flyway = new Flyway();
		flyway.setDataSource(DBHelper.getDataSource());
		
		flyway.migrate();
	}
}
