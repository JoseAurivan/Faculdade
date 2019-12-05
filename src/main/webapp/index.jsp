<%-- 
    Document   : index
    Created on : 17/10/2019, 10:37:09
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
        Já tem uma conta? 
        <a  href="${linkTo[ClientesController].login}" class="badge badge-primary">Login</a><br>
        <a href="${linkTo[ClientesController].form}" class="badge badge-primary">Cadastre-se</a><br>
        

        
    </body>
</html>
