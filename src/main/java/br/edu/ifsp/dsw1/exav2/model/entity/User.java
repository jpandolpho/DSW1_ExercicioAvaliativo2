package br.edu.ifsp.dsw1.exav2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Foi utilizado o Lombok para facilitar a codificação.
@Getter
@Setter
@AllArgsConstructor
public class User {
	private String login;
	private String senha;
	
	//Método estático para authenticar o usuário, verificando se login e senha são iguais aos
	//recuperados do banco.
	public static boolean authenticate (User userFromSystem, String login, String senha) {
		if(userFromSystem != null) {
			return login.equals(userFromSystem.login) && senha.equals(userFromSystem.senha);
		}
		return false;
	}
}
