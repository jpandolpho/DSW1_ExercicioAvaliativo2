//Command para levar o usuário a página de cadastro de usuários.
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "logged/form_user.jsp";
	}

}
