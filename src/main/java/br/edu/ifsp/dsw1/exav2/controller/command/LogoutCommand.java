package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return "index.jsp";
	}

}
