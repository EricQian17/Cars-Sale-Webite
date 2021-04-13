<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Returned car</title>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <h2>Car details</h2>
        
        <ul>
            <li>ID: <c:out value="${returnedCar.id}"/></li>
            <li>Name: <c:out value="${returnedCar.name}"/></li>
            <li>Price: <c:out value="${returnedCar.price}"/></li>
        </ul>
        
        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>        
        
    </body>
</html>