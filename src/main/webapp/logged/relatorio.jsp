<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="br.edu.ifsp.dsw1.exav2.model.entity.Pedido"%>
<!DOCTYPE html>
<!-- Página de relatório. -->
<html>
<jsp:include page="../includes/head.html"/>
<body>
	<!-- Verificando se foi recebida alguma lista. -->
	<%
	var pedidos = (List<Pedido>) request.getAttribute("pedidos");
	if(pedidos == null || pedidos.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/logged/logged.jsp");
	}else{
	%>
	<jsp:include page="includes/navbar.jsp"/>
	<hr>
	<!-- Verificando se existe alguma mensagem. -->
	<%
	String msg = (String) request.getAttribute("message");
	if (msg != null ) {
	%>
	<h1><%=msg%></h1>
	<hr>
	<%} %>
	<h5>Buscar</h5>
	<!-- Form para realizar busca a partir de um nome de cliente fornecido. -->
	<form action="pedido.do?action=buscarCliente" method="post">
		<input type="text" name="textBusca" placeholder="Digite o nome do cliente.">
		<button type="submit">Buscar</button>
	</form>
	<hr>
	<!-- Tabela exibindo os dados recebidos. -->
	<table border="1">
		<thead>
			<th>Nome do Cliente</th>
			<th>Endereço de Entrega</th>
			<th>Valor</th>
			<th>Descrição</th>
			<th>Responsável</th>
			<th colspan="2">Ações</th>
		</thead>
		<tbody>
		<%
		for(var pedido : pedidos){
		%>
			<tr>
				<td><%=pedido.getNomeCliente()%></td>
				<td><%=pedido.getEnderecoEntrega()%></td>
				<td>R$ <%=pedido.getValor()%></td>
				<td><%=pedido.getDescricao()%></td>
				<td><%=pedido.getLogin() %></td>
				<!-- Utilizamos o id do pedido como parametro da request para edição e exclusão de um pedido. -->
				<td><a href="pedido.do?action=update&id=<%=pedido.getId()%>">Editar</a></td>
				<td><a href="pedido.do?action=delete&id=<%=pedido.getId()%>" 
					onclick="return confirm('Confirma a exclusão?');">Excluir</a></td>
			</tr>
		</tbody>
		<%} %>
	</table>
	<%} %>
</body>
</html>