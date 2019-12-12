<%-- 
    Document   : lista
    Created on : 12/12/2019, 08:27:05
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
        <h1>Lista das Vendas</h1>
        <table class="table">
            <tr>
                <td>Cliente</td>
                <td> Data </td>
                <tD>Itens e Valor</tD>
                
            </tr> 
        
    <c:forEach items="${vendaList}" var="v">
        <tr>
            <td>${v.cliente.nome}</tD>
            <tD>${v.dataVenda}</tD>
                <c:forEach items="${v.itens}" var="i">
                <td>${i.produto.descricao} X ${i.qtd} = ${i.total()} </tD>
                
                </c:forEach>
            
        </tr>
    </c:forEach>           
        </table>
        <a  href="${linkTo[ClientesController].logado}" class="badge badge-primary">Voltar</a><br>
    </body>
</html>
