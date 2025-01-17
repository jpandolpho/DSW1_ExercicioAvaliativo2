package br.edu.ifsp.dsw1.exav2.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pedido {
	private int id;
	private String nomeCliente;
	private String enderecoEntrega;
	private double valor;
	private String descricao;
	private String login;
}
