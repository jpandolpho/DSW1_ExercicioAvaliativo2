//Command que busca os pedidos de um cliente informado pelo usuário.
package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarClienteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var cliente = request.getParameter("textBusca");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		List<Pedido> pedidos = dao.retrieveByName(cliente);
		request.setAttribute("pedidos", pedidos);
		
		return "/logged/relatorio.jsp";
	}

}
