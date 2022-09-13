<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="Hola Mundo, mostrando un literal" />
	<br>
	<c:out value="Hola Mundo, mostrando un parametro desde el ambito del request:  " />	${requestScope.usuario}
	<br>
	<c:out	value="Hola Mundo, mostrando un parametro desde el ambito del request:  " />	${sessionScope.usuario}
	<br>
	 Parametro en el request	<%=request.getAttribute("usuario")%>
	<br> Parametro en la session
	<%=session.getAttribute("usuario")%>
	<br>
	<c:if test="${usuario != null}">
		<p>
			El nombre del usuario es: <c:out value="${usuario}" />			
		<p>
	</c:if>
	
	<c:set var="income" scope="request" value="${(4*4000)}"/>
	
	
	<c:if test="${income != null}">
		<p>
			My income is: <c:out value="${income}" />			
		<p>
	</c:if>
	
 
	
	<!-- FORMA DE HACERLO CON SCRIPTLETS, LA MENOS RECOMENDADA DE TODO DEBIDO A SU "ENGORROSIDAD" -->
	
	<%
	String usuario = (String) request.getAttribute("usuario");
	if (usuario.equals("Javi")) {
	%>
	<p>Este es el usuario que esperabamos</p>
	<%
	} else {
	%>
	<p>Es un usuario distinto al que esperabamos</p>
	<%}%>


<br>



<a href="uno">Controlador 1</a>

</body>
</html>