package br.edu.ifsp.dsw1.exav2.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.exav2.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.exav2.model.entity.User;

/*CREATE TABLE tb_users (
    -> login VARCHAR(50) PRIMARY KEY,
    -> senha VARCHAR(45)
    -> );
*/
public class UserDaoImpl implements UserDao {
	
	private static final String INSERT = "INSERT INTO tb_users(login,senha) VALUES (?,?)";
	private static final String SELECT_BY_LOGIN = "SELECT * FROM tb_users WHERE login=?";

	@Override
	public boolean insert(User user) {
		int rows = 0;
		if(user != null) {
			try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1,user.getLogin());
				statement.setString(2, user.getSenha());
				
				rows = statement.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public User findByLogin(String login) {
		User user = null;
		try(var connection = DatabaseConnection.getConnection();
			var statement = connection.prepareStatement(SELECT_BY_LOGIN)){
			
			statement.setString(1, login);
			var resultSet = statement.executeQuery();
			if(resultSet.next()) {
				user = new User(resultSet.getString("login"),resultSet.getString("senha"));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

}
