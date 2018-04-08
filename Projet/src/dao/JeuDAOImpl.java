package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Jeu;
import beans.Utilisateur;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;


public class JeuDAOImpl implements JeuDAO{


	public void suppr(String nom) {
		// avoid select * queries because of performance issues,
		// only query the columns you need
		Suppr("DELETE FROM Jeu WHERE nom = '"+ nom +"'");
	}

	public void Suppr(String sql) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = initialisationRequetePreparee( connexion, sql, false);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
           
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

    }


}