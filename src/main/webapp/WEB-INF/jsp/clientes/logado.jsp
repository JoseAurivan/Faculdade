<%-- 
    Document   : logado
    Created on : 28/11/2019, 08:07:00
    Author     : jose.filho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>CRUD Cliente e Produto</h1>
        
        Nome:${clienteSession.cliente.nome}<br>
        <a href="${linkTo[ProdutosController].form}" class="badge badge-dark">Formulario de Inserção de Produtos</a><br> 
        
         <a href="${linkTo[ClientesController].lista}" class="badge badge-dark">lista de Clientes</a><br> 
        <a href="${linkTo[ProdutosController].lista}" class="badge badge-dark">Produtos Disponiveis</a><br>
        
        <a href="${linkTo[VendasController].formv}" class="badge badge-dark">Realizar uma Venda</a><br>
        <a href="${linkTo[ClientesController].logout}" class="badge badge-danger">Sair</a>
    </body>
</html>
