<%-- 
    Document   : lista
    Created on : 24/10/2019, 08:48:13
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
        <h1>Lista de produtos</h1>
        Nome:${clienteSession.cliente.nome}<br>
        
        <table class="table">
            <tr>
                <td>ID</td>
                <td>DESCRICAO</td>
                <td>VALOR</td>
            </tr>
    <c:forEach items="${produtoList}" var="produto">
        <tr>
            <td>${produto.id}</td> 
            <tD>${produto.descricao}</tD>
            <td>${produto.valor}</tD>
            <tD><a onclick="return window.confirm('Deseja excluir o produto ${produto.descricao} ?')" href="${linkTo[ProdutosController].excluir}?id=${produto.id}">Excluir</a></td>
            <tD><a href="${linkTo[ProdutosController].alterar}?id=${produto.id}">Alterar</a></td>
        </tr>
    </c:forEach>
        </table>
        <a  href="${linkTo[ClientesController].logado}" class="badge badge-primary">Voltar</a><br>
    </body>
</html>
