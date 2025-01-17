<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/includes/head.html"/>
<body>
	<jsp:include page="/includes/navbar.jsp"/>
	<hr>
	<!-- Verificando se existe alguma mensagem. -->
	<%
	String msg = (String) request.getAttribute("message");
	if (msg != null ) {
	%>
	<h1><%=msg%></h1>
	<hr>
	<%} %>
	<!-- Form para login do usuário. -->
	<form action="<%= request.getContextPath() %>/front.do?action=login" method="post">
		<label for="login">Login</label> 
		<input type="text" id="login" name="textLogin"
			placeholder="Digite seu login." required="required">
		
		<br/><br/>
			
		<label for="password">Senha</label> 
		<input type="password" id="password" name="textSenha"
			placeholder="Digite sua senha." required="required">
		
		<br/>
		
		<button type="submit" style="text-align: center;">Entrar</button>
	</form>
</body>
</html>