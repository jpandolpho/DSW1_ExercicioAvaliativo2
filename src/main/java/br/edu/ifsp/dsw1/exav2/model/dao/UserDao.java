package br.edu.ifsp.dsw1.exav2.model.dao;

import br.edu.ifsp.dsw1.exav2.model.entity.User;

public interface UserDao {
	boolean insert(User user);
	User findByLogin(String login);
}
