package dao;

import beans.Utilisateur;

public interface UtilisateurDao {
	/* création d'un utilisateur à l'inscription  */
    void creer( Utilisateur utilisateur ) throws DAOException; 
    /* recherche d'un utilisateur à la connexion */
    Utilisateur trouver( String email ) throws DAOException;

    Utilisateur signin(String email, String mdp) throws DAOException;

}
