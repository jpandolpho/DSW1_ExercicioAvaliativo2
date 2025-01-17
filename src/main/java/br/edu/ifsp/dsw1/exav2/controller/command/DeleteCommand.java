//Command para deletar um pedido.
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recuperação do id do pedido
		var id = Integer.parseInt(request.getParameter("id"));
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		//Deletando o pedido.
		boolean deleted = dao.delete(id);
		
		String message;
		if(deleted) {
			message = "Pedido excluído com sucesso.";
		}else {
			message = "Erro ao excluir o pedido.";
		}
		
		request.setAttribute("message", message);
		
		return "pedido.do?action=orders";
	}

}
