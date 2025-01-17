//Filtro de autenticação de usuário.
package br.edu.ifsp.dsw1.exav2.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//Queremos verificar se o usuário é válido sempre que entramos numa página dentro do diretório
//logged e sempre que fazemos uma requisição que passa por PedidoServlet(pedido.do)
@WebFilter(urlPatterns= {"/logged/*","/pedido.do"})
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Recuperando a requisição
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		//Verificando os dados da sessão para verificar validade dela
		if (session != null && session.getAttribute("user_id") != null) {
			chain.doFilter(request, response);
		} else {
			//Caso não seja válida, mandamos o usuário para a index.
			request.setAttribute("message", "Acesso permitido apenas para usuário logado.");
			
			var dispatcher = request.getRequestDispatcher("/front.do?action=index");
			dispatcher.forward(request, response);
		}	
	}

}
