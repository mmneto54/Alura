<%--
  Created by IntelliJ IDEA.
  User: manoel.marcal.m.neto
  Date: 21/03/2018
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Import da taglib -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
<form action="/produtos" method="GET">
    <h1>Lista de Produtos</h1>
    <table>
        <tr><td colspan="3" align="center">
            ${sucesso} ${falha}
        </td></tr>
        <tr>

            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
        </tr>

        <c:forEach items="${produtos}" var="produto" varStatus="status">
            <tr>
                <td><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a></td>
                <td>${produto.descricao}</td>
                <td>${produto.pagina}</td>
            </tr>
        </c:forEach>

    </table>

</form>
</body>
</html>