package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import br.edu.ifsp.dsw1.exav2.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateOrderCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var nome = request.getParameter("textNomeCliente");
		var endereco = request.getParameter("textEnderecoEntrega");
		var valor = Double.parseDouble(request.getParameter("textValor"));
		var descricao = request.getParameter("textDescricao");
		var login = request.getParameter("textLogin");
		
		if(endereco.equals("")) {
			endereco = null;
		}
		if(descricao.equals("")) {
			descricao = null;
		}
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		Pedido pedido = new Pedido();
		pedido.setNomeCliente(nome);
		pedido.setDescricao(descricao);
		pedido.setEnderecoEntrega(endereco);
		pedido.setValor(valor);
		
		boolean saved = dao.create(user, pedido);
		
		String message;
		if(saved) {
			message = "Pedido salvo com sucesso.";
		}else {
			message = "Erro ao salvar pedido.";
		}
		
		request.setAttribute("message", message);
		
		return "logged/form_pedido.jsp";
	}

}
