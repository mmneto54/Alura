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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java 8, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>

 <form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto" enctype="multipart/form-data" >

             <div>
                 <label>Título</label>
                 <form:input path="titulo" />
                 <form:errors path="titulo" />
             </div>

            <div>
                <label>Descrição</label>
                <form:textarea rows="10" cols="20" path="descricao" />
                <form:errors path="descricao" />
            </div>
            <div>
                 <label>Data de Lançamento</label>
                 <form:input path="dataLancamento" />
                 <form:errors path="dataLancamento"/>
            </div>

            <div>
                <label>Páginas</label>
                <form:input path="pagina" />
                <form:errors path="pagina" />
            </div>

          <div>
              <label>Súmario</label>
              <input name="sumario" type="file" />
          </div>


            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>${tipoPreco}</label>
                    <form:input path="precos[${status.index}].valor" />
                    <form:hidden path="precos[${status.index}].tipoPreco" value="${tipoPreco}" />
                </div>
            </c:forEach>


         <button type="submit">Cadastrar</button>
 </form:form>
</body>
</html>