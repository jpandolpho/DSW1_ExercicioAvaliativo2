package br.edu.ifsp.dsw1.exav2.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private String login;
	private String senha;
	
	public User(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public static boolean authenticate (User userFromSystem, String login, String senha) {
		if(userFromSystem != null) {
			return login.equals(userFromSystem.login) && senha.equals(userFromSystem.senha);
		}
		return false;
	}
}
