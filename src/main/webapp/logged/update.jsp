<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.edu.ifsp.dsw1.exav2.model.entity.Pedido"%>
<!DOCTYPE html>
<!-- Página de edição de pedido. -->
<html>
<jsp:include page="../includes/head.html"/>
<body>
	<jsp:include page="includes/navbar.jsp"/>
	<hr>
	<!-- Verificando se o pedido que foi recebido realmente existe. -->
	<%
	var pedido = (Pedido) request.getAttribute("pedido");
	if(pedido == null){
		response.sendRedirect(request.getContextPath()+"/logged/relatorio.jsp");
	}else{
	%>
	<!-- Formulário para edição. Os campos já vem pré-preenchidos com os valores atuais. -->
	<!-- Não é dado opção de alterar nem o campo login, nem o id do pedido. -->
	<form action="pedido.do?action=commitUpdate" method="post">
		<label for="nomeCliente">Nome do Cliente</label> 
		<input type="text" id="nomeCliente" name="textNomeCliente"
			placeholder="Digite o nome do cliente." required="required" value="<%= pedido.getNomeCliente() %>">
		
		<br/><br/>
			
		<label for="enderecoEntrega">Endereco de Entrega</label> 
		<input type="text" id="enderecoEntrega" name="textEnderecoEntrega"
			placeholder="Digite o endereço de entrega." value="<%= pedido.getEnderecoEntrega() %>">
		
		<br/><br/>
			
		<label for="valor">Valor</label> 
		<input type="number" id="valor" name="textValor"
			placeholder="Digite o valor." required="required" min="0" step="0.01" value="<%= pedido.getValor() %>">
		
		<br/><br/>
		
		<label for="descricao">Descricao</label> 
		<input type="text" id="descricao" name="textDescricao"
			placeholder="Digite o endereço de entrega." value="<%= pedido.getDescricao() %>">
		
		<br/><br/>
		<!-- Passamos o id do pedido como um hidden no formulário. -->
		<input type="hidden" name="textId" value=<%=pedido.getId() %>>
		<button type="submit" style="text-align: center;">Atualizar</button>
	</form>
	<%} %>
</body>
</html>