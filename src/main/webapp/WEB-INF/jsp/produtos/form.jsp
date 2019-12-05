<%-- 
    Document   : form
    Created on : 24/10/2019, 08:48:06
    Author     : jose.filho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <header><h2>Formulario Produtos</h2></header>
        
    <c:forEach items="${errors}" var="erro">
        <p style=" color: red">${erro.message}</p><br>
    </c:forEach>
        
        
        <form action="${linkTo[ProdutosController].salvar}" method="post" class="form-inline">
            
            <input type="number" name ="produto.id" hidden="" value="${produto.id}">
            
            Descricao:<input type="text" name="produto.descricao" value="${produto.descricao}"autofocus><br>
            Valor:<input type="number" name="produto.valor" value="${produto.valor}"><br>
            <input type="submit" value="Enviar">
            
        </form>
    </body>
</html>
