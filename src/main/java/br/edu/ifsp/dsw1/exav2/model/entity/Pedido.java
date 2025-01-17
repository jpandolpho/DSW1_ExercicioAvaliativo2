package br.edu.ifsp.dsw1.exav2.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Foi utilizado o Lombok para facilitar a codificação.
//Não foi criado construtor com argumentos para Pedido pois existiam casos onde não eram necessários
//todos os atributos, optando nesses casos por usar o construtor sem argumentos e sets para o necessário.
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
