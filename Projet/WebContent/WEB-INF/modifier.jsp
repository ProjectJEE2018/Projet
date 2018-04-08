<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html>
    <head>
        <meta charset="utf-8" />
        <title>Modification du compte</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
    <body>
        <form method="post" action="modifier">
            <fieldset>
                <legend>Informations personnelles</legend>
                <p>Vous pouvez modifier vos informations personnelles via ce formulaire.</p>

				<label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${sessionScope.sessionUtilisateur.email}"/>" size="20" maxlength="60"  disabled/>
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
                
				<label for="nom">Pseudo <span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
				<label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                
                <label for="date">Date de naissance <span class="requis">*</span></label>
                <input type="date" id="naissance" name="naissance" value="<c:out value="${utilisateur.naissance}"/>" />
                <span class="erreur">${form.erreurs['naissance']}</span>
              
                <br />
 			
 	
 			
                <input type="submit" value="Modifier" class="sansLabel" />
                <br />
                <a href="restriction">Accès aux jeux !</a>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>