<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des joueurs</title>
</head>
<body>

        <form method="post" action="InterdireJoueur">
            <fieldset>
                <legend>Bannir un joueur</legend>
                <p>Quel est le nom du joueur que vous voulez interdire</p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJoueur" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJoueur']}</span>
                <br />
               
                <input type="submit" value="interdire" class="sansLabel" />
            </fieldset>
        </form>
        
        
		<form method="post" action="réinstaurerJoueur">
            <fieldset>
                <legend>Réinstaurer un joueur</legend>
                <p>Veuillez saisir le nom du jueur à réinstaurer</p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJoueur" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJoueur']}</span>
                <br />
               
                <input type="submit" value="réinstaurer" class="sansLabel" />
            </fieldset>
        </form>
        
        

</body>
</html>