<%-- 
    Document   : fromv
    Created on : 14/11/2019, 08:38:49
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
        <c:forEach items="${errors}" var="erro">
        <p style=" color: red">${erro.message}</p><br>
    </c:forEach>
        <table class="table table-dark">
    <c:forEach items="${produtos}" var="p">
                    <tr>

                        <td>
                            <form action="${linkTo[VendasController].addItem}" method="post">
                                ${p.id}
                                ${p.descricao}
                                <input type="hidden" name="item.produto.id" value="${p.id}">
                                <input type="hidden" name="item.produto.descricao" value="${p.descricao}">
                                <input type="text" readonly="" name="item.produto.valor" value="${p.valor}">
                                <input type="text" name="item.qtd">
                                <input type="submit" value="Comprar">

                            </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <table class="table table-dark">
            <tr>
                <tD>ID:</tD>
                <tD>Descricao:</tD>
                <tD>Valor</tD>
                <td>Quantidade</td>
                <td>ValorXQuantida</td>
            </tr>
                    
                    <c:forEach items="${vendaprod.itens}" var="item" varStatus="i">
                        
                    <Tr>
                        <tD>  ${i.index+1} </tD>
                        <td> ${item.produto.descricao}</td>
                        <td> ${item.produto.valor}</td>
                        <td> ${item.qtd}</td>
                        <td> ${item.total()}</td>
                    </Tr>  
                        
                </c:forEach>
        </table>
        <table class="table table-dark">
                    <tr>
                        <td>TOTAL:</td>
                        <td>${vendaprod.total()}</td>
                    </tr>
        </table>    
                    <Br>
                    <a href="${linkTo[VendasController].salvarVenda}" class="badge badge-primary">CONCLUIR</a>
                    <a href="${linkTo[VendasController].logout}" class="badge badge-danger">SAIR</a>
                    <a  href="${linkTo[ClientesController].logado}" class="badge badge-light">Voltar</a><br>
        
    </body>
</html>
