package br.edu.ifsp.dsw1.exav2.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.controller.command.Command;
import br.edu.ifsp.dsw1.exav2.controller.command.CreateOrderCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.CreateUserCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.LoggedCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.LogoutCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.NewOrderCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.NewUserCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.OrdersCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pedido.do")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");
		
		if("logged".equals(action)) {
			command = new LoggedCommand();
		}else if("newUser".equals(action)) {
			command = new NewUserCommand();
		}else if("newOrder".equals(action)) {
			command = new NewOrderCommand();
		}else if("orders".equals(action)) {
			command = new OrdersCommand();
		}else if("logout".equals(action)) {
			command = new LogoutCommand();
		}else if("createUser".equals(action)) {
			command = new CreateUserCommand();
		}else if("createOrder".equals(action)) {
			command = new CreateOrderCommand();
		}
		
		String view = command.execute(request,response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
