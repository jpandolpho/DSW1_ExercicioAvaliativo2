package br.edu.ifsp.dsw1.exav2.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.exav2.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommitUpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var nome = request.getParameter("textNomeCliente");
		var endereco = request.getParameter("textEnderecoEntrega");
		var valor = Double.parseDouble(request.getParameter("textValor"));
		var descricao = request.getParameter("textDescricao");
		var id = Integer.parseInt(request.getParameter("textId"));
		
		if(endereco.equals("")) {
			endereco = null;
		}
		if(descricao.equals("")) {
			descricao = null;
		}
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedido.setNomeCliente(nome);
		pedido.setEnderecoEntrega(endereco);
		pedido.setValor(valor);
		pedido.setDescricao(descricao);
		
		boolean updated = dao.update(pedido);
		
		String message;
		if(updated) {
			message = "Pedido atualizado com sucesso.";
		}else {
			message = "Erro ao atualizar o pedido.";
		}
		
		request.setAttribute("message", message);
		
		return "pedido.do?action=orders";
	}

}
