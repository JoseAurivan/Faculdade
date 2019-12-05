<%-- 
    Document   : lista
    Created on : 24/10/2019, 08:48:41
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
        <h1>Lista Clientes</h1>
        <table class="table">
            <tR>
                <td>ID</td>
                <td>Nome</td>
                <td colspan="2">Operacoes</tD>
            </tR>    
        
    <c:forEach items="${clienteList}" var="cliente">
        <Tr>
            <TD>${cliente.id}</td> 
            <td>${cliente.nome}</td>
            <tD><a onclick="return window.confirm('Deseja excluir o produto ${cliente.nome} ?')" href="${linkTo[ClientesController].excluir}?id=${cliente.id}">Excluir</a></td>
            <tD><a href="${linkTo[ClientesController].alterar}?id=${cliente.id}">Alterar</a></td>
        </Tr>
        </c:forEach>
        
        </table>
        <a  href="${linkTo[ClientesController].logado}" class="badge badge-primary">Voltar</a><br>
        
    </body>
</html>
