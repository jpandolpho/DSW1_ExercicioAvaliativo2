//Command para criação de um novo usuário.
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.UserDao;
import br.edu.ifsp.dsw1.exav2.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recuperando dados do formulário
		var login = request.getParameter("textLogin");
		var senha = request.getParameter("textSenha");
		
		UserDao dao = new UserDaoFactory().factory();
		
		//Criando novo usuário
		User user = new User(login,senha);
		boolean saved = dao.insert(user);

		String message;
		if(saved) {
			message = "Usuario criado com sucesso.";
		}else {
			message = "Erro ao criar o usuário.";
		}
		request.setAttribute("message",message);
		
		return "/logged/form_user.jsp";
	}

}
