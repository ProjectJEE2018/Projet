<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
         <link type="text/css" rel="stylesheet" href="style.css" />
        <title>Utilisateurs : </title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <h1>Liste des utilisateurs inscrits :</h1>

        <c:forEach items="${ messages }" var="message" varStatus="boucle">
        <fieldset>
            <p> ${ message }</p>
        </fieldset>
        </c:forEach>
    </body>
</html>