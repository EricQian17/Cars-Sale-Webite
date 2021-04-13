<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Car saved</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <p>
            Successfully saved  <c:out value="${sessionScope.carName}"/>
            car priced <c:out value="${sessionScope.carPrice}"/>
        </p>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>  
    </body>
</html>
