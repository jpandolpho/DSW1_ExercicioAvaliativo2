package br.edu.ifsp.dsw1.exav2.model.dao;

public class PedidoDaoFactory {
	public PedidoDao factory() {
		return new PedidoDaoDatabase();
	}
}
