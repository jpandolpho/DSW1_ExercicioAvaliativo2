package br.edu.ifsp.dsw1.exav2.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import br.edu.ifsp.dsw1.exav2.model.entity.User;

public interface PedidoDao {
	boolean create(User user, Pedido pedido);
	Pedido retrive(int id);
	List<Pedido> retrieveAll();
	List<Pedido> retrieveByName(String name);
	boolean update (Pedido updatedPedido);
	boolean delete (Pedido pedido);
}
