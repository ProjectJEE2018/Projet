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
        	<legend>"Joueur"</legend>
            <p> ${ message }</p>
        </fieldset>
        </c:forEach>
        
         <br />
          <br />
           <br />
            <br />
            <form method="post" action="test_jdbc">
            <fieldset>
            
                <legend>Bannir un joueur</legend>
                <p>Quel est le nom du joueur que vous voulez interdire ?</p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJoueur" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJoueur']}</span>
                <br />
               
                <input type="submit" value="interdire" class="sansLabel" />
            </fieldset>
        </form>
        <br />
        
		 <form method="post" action="test_jdbc">
            <fieldset>
                <legend>Réinstaurer un joueur</legend>
                <p>Veuillez saisir le nom du jueur à réinstaurer : </p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJoueur" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJoueur']}</span>
                <br />
               
                <input type="submit" value="réinstaurer" class="sansLabel" />
            </fieldset>
        </form>
    </body>
</html>