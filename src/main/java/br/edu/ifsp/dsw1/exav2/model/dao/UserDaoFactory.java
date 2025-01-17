package br.edu.ifsp.dsw1.exav2.model.dao;

public class UserDaoFactory {
	public UserDao factory() {
		return new UserDaoImpl();
	}
}
