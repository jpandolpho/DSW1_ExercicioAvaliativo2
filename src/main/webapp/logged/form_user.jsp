<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html"/>
<body>
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
	<!-- Form para cadastrar de novo usuário. -->
	<form action="pedido.do?action=createUser" method="post">
		<label for="login">Login</label> 
		<input type="text" id="login" name="textLogin"
			placeholder="Digite o login." required="required">
		
		<br/><br/>
			
		<label for="password">Senha</label> 
		<input type="password" id="password" name="textSenha"
			placeholder="Digite a senha." required="required">
		
		<br/>
		
		<button type="submit" style="text-align: center;">Cadastrar</button>
	</form>
</body>
</html>