//Command para redirecionar o usuário para a página de edição de pedido
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Aqui, recuperamos qual é o pedido que será editado
		var id = Integer.parseInt(request.getParameter("id"));
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		Pedido pedido = dao.retrive(id);
		
		//Adicionamos o pedido na request para ele ser recuperado na update.jsp
		request.setAttribute("pedido", pedido);
		
		return "/logged/update.jsp";
	}

}
