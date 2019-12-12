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
        Nome:${clienteSession.cliente.nome}<br>
        <h1>Lista das Vendas</h1>
        <table class="table">

        
    <c:forEach items="${vendaList}" var="v">
        <tr>
            <td>Nome do Cliente: ${v.cliente.nome}</tD>
            <tD>Data da Compra: ${v.dataVenda}</tD>
                <c:forEach items="${v.itens}" var="i">
                <td>Descricao: ${i.produto.descricao} Quantidade: ${i.qtd} = Valor: ${i.total()} </tD>
               
                </c:forEach>
                <tD>TOTAL:${v.total()}</tD>
                <tD><tD><a onclick="return window.confirm('Deseja excluir esta venda ?')" href="${linkTo[VendasController].excluir}?id=${v.id}">Excluir</a></td></tD>
        </tr>
    </c:forEach>           
        </table>
        <a  href="${linkTo[ClientesController].logado}" class="badge badge-primary">Voltar</a><br>
    </body>
</html>
