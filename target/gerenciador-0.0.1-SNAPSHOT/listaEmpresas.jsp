<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/deletarEmpresa" var="linkServletDeletarEmpresa"/>
<c:url value="/editarEmpresa" var="linkServletEditarEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	Lista de empresas: <br />
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			
			<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> <a href="${linkServletEditarEmpresa}?id=${empresa.id}">editar</a> | <a href="${linkServletDeletarEmpresa}?id=${empresa.id}">remover</a></li>
		</c:forEach>
	</ul>
	
</body>
</html>