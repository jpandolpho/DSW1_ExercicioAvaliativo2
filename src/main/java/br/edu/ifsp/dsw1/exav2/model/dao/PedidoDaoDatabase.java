package br.edu.ifsp.dsw1.exav2.model.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.exav2.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.exav2.model.entity.Pedido;
import br.edu.ifsp.dsw1.exav2.model.entity.User;

/*CREATE TABLE tb_orders(
    idpedidos INT PRIMARY KEY AUTO_INCREMENT,
    nomeCliente VARCHAR(145) NOT NULL,
    enderecoEntrega VARCHAR(200),
    valor DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(300),
    login VARCHAR(50) NOT NULL,
    FOREIGN KEY (login) REFERENCES tb_users(login) ON DELETE CASCADE
    );
*/

public class PedidoDaoDatabase implements PedidoDao {
	
	private static final String INSERT = "INSERT INTO tb_orders(nomeCliente,enderecoEntrega,valor,descricao,login) VALUES (?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM tb_orders WHERE idpedidos=?";
	private static final String SELECT_ALL = "SELECT * FROM tb_orders";
	private static final String SELECT_BY_NAME = "SELECT * FROM tb_orders WHERE nomeCliente LIKE ?";
	private static final String UPDATE = "UPDATE tb_orders SET nomeCliente=?, enderecoEntrega=?, valor=?,descricao=? WHERE idpedidos=?";
	private static final String DELETE = "DELETE FROM tb_orders WHERE idpedidos=?";

	@Override
	public boolean create(User user, Pedido pedido) {
		if(pedido !=null) {
			int rows = -1;
			try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(INSERT)){
				
				preparedStatement.setString(1, pedido.getNomeCliente());
				preparedStatement.setString(2, pedido.getEnderecoEntrega());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				preparedStatement.setString(5, user.getLogin());
				
				rows = preparedStatement.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return rows > 0;
		}
		return false;
	}

	@Override
	public Pedido retrive(int id) {
		Pedido pedido = null;
		if(id>0) {
			try(var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
				preparedStatement.setInt(1, id);
				
				var result = preparedStatement.executeQuery();
				if(result.next()) {
					pedido = new Pedido();
					pedido.setId(result.getInt("idpedidos"));
					pedido.setNomeCliente(result.getString("nomeCliente"));
					pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
					pedido.setValor(result.getDouble("valor"));
					pedido.setDescricao(result.getString("descricao"));
					pedido.setLogin(result.getString("login"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
				pedido = null;
			}
		}
		return pedido;
	}

	@Override
	public List<Pedido> retrieveAll() {
		List<Pedido> pedidos = new LinkedList<Pedido>();
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_ALL)){
			
			var result = preparedStatement.executeQuery();
			
			while(result.next()) {
				var pedido = new Pedido();
				pedido.setId(result.getInt("idpedidos"));
				pedido.setNomeCliente(result.getString("nomeCliente"));
				pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
				pedido.setValor(result.getDouble("valor"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setLogin(result.getString("login"));
				pedidos.add(pedido);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			pedidos = new LinkedList<Pedido>();
		}
		return pedidos;
	}

	@Override
	public List<Pedido> retrieveByName(String name) {
		List<Pedido> pedidos = new LinkedList<Pedido>();
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_BY_NAME)){
			
			name = "%"+name+"%";
			preparedStatement.setString(1,name);
			var result = preparedStatement.executeQuery();
			
			while(result.next()) {
				var pedido = new Pedido();
				pedido.setId(result.getInt("idpedidos"));
				pedido.setNomeCliente(result.getString("nomeCliente"));
				pedido.setEnderecoEntrega(result.getString("enderecoEntrega"));
				pedido.setValor(result.getDouble("valor"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setLogin(result.getString("login"));
				pedidos.add(pedido);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			pedidos = new LinkedList<Pedido>();
		}
		return pedidos;
	}

	@Override
	public boolean update(Pedido updatedPedido) {
		if(updatedPedido != null) {
			int rows = -1;
			try(var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(UPDATE)){
					
					preparedStatement.setString(1, updatedPedido.getNomeCliente());
					preparedStatement.setString(2, updatedPedido.getEnderecoEntrega());
					preparedStatement.setDouble(3, updatedPedido.getValor());
					preparedStatement.setString(4, updatedPedido.getDescricao());
					preparedStatement.setInt(5, updatedPedido.getId());
					
					rows = preparedStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return rows > 0;
		}
		return false;
	}

	@Override
	public boolean delete(Pedido pedido) {
		if(pedido!=null) {
			int rows = -1;
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(DELETE)) {
				preparedStatement.setInt(1, pedido.getId());

				rows = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows > 0;
		}
		return false;
	}

}
