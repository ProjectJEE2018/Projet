<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link type="text/css" rel="stylesheet" href="style.css" />
       
<head>
<title>Liste des jeux</title>
</head>

<body>

        <form method="get" action="ListeJeux">
            <fieldset>
                <legend>Ajouter un jeu</legend>
                <p>Veuillez remplir les caractéristiques du jeu que vous souhaitez ajouter</p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJeuadd" value="<c:out value="${jeu.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJeu']}</span>
                <br />
               
                <input type="submit" value="ajouter" class="sansLabel" />
            </fieldset>
        </form>
        
        
		<form method="get" action="ListeJeux">
            <fieldset>
                <legend>Supprimer un jeu</legend>
                <p>Veuillez saisir le nom du neu à supprimer</p>

                <label for="nom">Nom<span class="requis">*</span></label>
                <input type="text" id="nom" name="nomJeusuppr" value="<c:out value="${jeu.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nomJeu']}</span>
                <br />
               
                <input type="submit" value="supprimer" class="sansLabel" />
            </fieldset>
        </form>
        
</body>
</html>