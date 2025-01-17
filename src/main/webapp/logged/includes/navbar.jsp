<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav>
	<a href="<%= request.getContextPath() %>/pedido.do?action=logged">ARQDSW1</a>
	<a href="<%= request.getContextPath() %>/pedido.do?action=newUser">Novo Usuário</a>
	<a href="<%= request.getContextPath() %>/pedido.do?action=newOrder">Novo Pedido</a>
	<a href="<%= request.getContextPath() %>/pedido.do?action=orders">Relatório</a>
	<a href="<%= request.getContextPath() %>/pedido.do?action=logout">Sair</a>
</nav>