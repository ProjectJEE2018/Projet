<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
        <title>Accès restreint</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

<fieldset>
	<legend> Espace joueurs </legend>

        <p>Vous êtes connecté(e) avec l'adresse ${sessionScope.sessionUtilisateur.email}, vous avez bien accès à l'espace restreint.</p>
<br />
<p> Vous pouvez modifier <a href="modifier">ici</a> vos informations personnelles. </p>
</fieldset>

    </body>

</html>