<%-- 
    Document   : form
    Created on : 24/10/2019, 08:48:34
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
        <header><h2>Formulario Clientes</h2></header>
        <form action="${linkTo[ClientesController].salvar}" method="post" class="form-inline">
            
            <input type="number" name ="cliente.id" hidden="" value="${cliente.id}" ><bR>
            Nome:<input type="text" name="cliente.nome" value="${cliente.nome}" autofocus><bR>
            Senha:<input type="password" name="cliente.senha" value="${cliente.senha}" autofocus><bR>
            <input type="submit" value="Enviar">
            
        </form>
    </body>
</html>
