<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/editarEmpresa" var="linkServletEditarEmpresa"/>
<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" var="dataFormatada" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletEditarEmpresa }" method="post">
		<input type="hidden" name="id" value="${empresa.id}">
		Nome: <input type="text" name="nome" value="${empresa.nome}" />
		<br />
		Data Abertura: <input type="text" name="data" value="${dataFormatada}" />
		<br />
		ID: <label>${empresa.id}</label>
		<br />		
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>