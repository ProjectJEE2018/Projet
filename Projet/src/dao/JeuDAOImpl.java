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

    private DAOFactory          daoFactory;
    private static final String SQL_INSERT_JEU = "INSERT INTO Jeux (nom) VALUES (?)";
    

    JeuDAOImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	public void suppr(String nom) {
		// avoid select * queries because of performance issues,
		// only query the columns you need
		Suppr("DELETE FROM Jeu WHERE nom = '"+ nom +"'");
	}

	  /*CETTE FONCTION NE FAIT RIEN...*/
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

	
	
	public void creer( Jeu jeu ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT_JEU, true, jeu.getNom());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du jeu, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                jeu.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du jeu en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
	
	  /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Jeu map( ResultSet resultSet ) throws SQLException {
        Jeu jeu = new Jeu();
        jeu.setId( resultSet.getLong( "id" ) );
        jeu.setNom( resultSet.getString( "nom" ) );
        
        return jeu;
    }

    
}