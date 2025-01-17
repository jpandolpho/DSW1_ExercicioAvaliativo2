//Command para realizar o login.
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recuperando valores do formulário
		var login = request.getParameter("textLogin");
		var senha = request.getParameter("textSenha");
		
		var dao = new UserDaoFactory().factory();
		var user = dao.findByLogin(login);
		
		//Checando se o usuário pode ser autenticado
		var authorized = User.authenticate(user, login, senha);
		
		String view;
		
		if(authorized) {
			//Caso o usuário seja válido, adicionamos ele a sessão e mandamos ele para a logged.
			var session = request.getSession(true);
			session.setAttribute("user_id", user);
			session.setMaxInactiveInterval(24 * 60 * 60);
			view = "pedido.do?action=logged";
		}else {
			//Caso não seja, mandamos ele de volta para index.
			request.setAttribute("message", "Usuario não reconhecido.");
			view = "/front.do?action=index";
		}
		return view;
	}

}
