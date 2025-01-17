<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html"/>
<body>
	<jsp:include page="includes/navbar.jsp"/>
	<hr>
	<%
	String msg = (String) request.getAttribute("message");
	if (msg != null ) {
	%>
	<h1><%=msg%></h1>
	<%} %>
	
	<form action="pedido.do?action=createOrder" method="post">
		<label for="nomeCliente">Nome do Cliente</label> 
		<input type="text" id="nomeCliente" name="textNomeCliente"
			placeholder="Digite o nome do cliente." required="required">
		
		<br/><br/>
			
		<label for="enderecoEntrega">Endereco de Entrega</label> 
		<input type="text" id="enderecoEntrega" name="textEnderecoEntrega"
			placeholder="Digite o endereço de entrega.">
		
		<br/><br/>
			
		<label for="valor">Valor</label> 
		<input type="number" id="valor" name="textValor"
			placeholder="Digite o valor." required="required" min="0" step="0.01">
		
		<br/><br/>
		
		<label for="descricao">Descricao</label> 
		<input type="text" id="descricao" name="textDescricao"
			placeholder="Digite o endereço de entrega.">
		
		<br/><br/>
		<button type="submit" style="text-align: center;">Cadastrar</button>
	</form>
</body>
</html>