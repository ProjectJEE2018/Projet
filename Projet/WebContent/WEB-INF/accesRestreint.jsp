<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
		  <link type="text/css" rel="stylesheet" href="style.css" />
        <title>Accès restreint</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
   
</head>
<body>

<fieldset>
	<legend> Espace joueurs </legend>

        <p>Vous êtes connecté(e) avec l'adresse ${sessionScope.sessionUtilisateur.email}, vous avez bien accès à l'espace restreint.</p>
<br />

		<h1> Liste des jeux disponibles </h1>

<c:forEach items="${ messages }" var="message" varStatus="boucle">
        <fieldset>
        	<legend>"Les jeux !"</legend>
            <p> ${ message }</p>
        </fieldset>
        </c:forEach>

        <br />


<p> Vous pouvez modifier <a href="modifier">ici</a> vos informations personnelles. </p>
</fieldset>

    </body>
<a href="deconnexion"> Se déconnecter </a>
</html>