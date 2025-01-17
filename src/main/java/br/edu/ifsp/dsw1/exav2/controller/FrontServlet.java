package br.edu.ifsp.dsw1.exav2.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.exav2.controller.command.Command;
import br.edu.ifsp.dsw1.exav2.controller.command.IndexCommand;
import br.edu.ifsp.dsw1.exav2.controller.command.LoginCommand;
import br.edu.ifsp.dsw1.exav2.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.exav2.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean flag = false;
       
    public FrontServlet() {
        super();
        if(!flag) {
	        var dao = new UserDaoFactory().factory();
	        User user = dao.findByLogin("admin");
	        if(user==null) {
	        	user = new User("admin","admin");
	        	flag = dao.insert(user);
	        }else {
	        	flag = true;
	        }
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Command command = null;
		
		if("login".equals(action)) {
			command = new LoginCommand();
		}else if("index".equals(action)) {
			command = new IndexCommand();
		}
		
		String view = command.execute(request,response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
