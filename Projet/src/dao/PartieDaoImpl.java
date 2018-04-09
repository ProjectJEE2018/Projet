package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.Jeu;
import beans.Utilisateur;
import beans.Partie;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class PartieDaoImpl implements PartieDao{
	
	private static final String SQL_INSERT = "INSERT INTO Partie (id, Jeu_id, Utilisateur_id, date_debut, date_fin, enCours) VALUES (?, ?, ?, NOW(), ?, TRUE)";
	private static final String SQL_SELECT_EN_COURS = "SELECT id, Jeu_id, Utilisateur_id, date_debut FROM Partie WHERE enCours = true";
	private static final String SQL_SELECT_FINI = "SELECT id, Jeu_id, Utilisateur_id, date_debut, date_fin FROM Partie WHERE enCours = false";
	private static final String SQL_FIN_PARTIE = "UPDATE Partie SET date_fin=NOW(), enCours=FALSE WHERE id=?";
	
	private DAOFactory daoFactory;

    PartieDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    

	public void creer(Partie partie) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, partie.getId(), partie.getId_jeu(), partie.getId_utilisateur(), null);
            int statut = preparedStatement.executeUpdate();
            
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de la partie, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                partie.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de la partie en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }      		
	}

	public void terminerPartie(Partie partie) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_FIN_PARTIE, false, partie.getId());
            int statut = preparedStatement.executeUpdate();
            
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la modification de la partie, aucune ligne modifiée dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }      		
		
	}
	
	 /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des parties (un
     * ResultSet) et un bean Partie.
     */
    private static Partie map( ResultSet resultSet ) throws SQLException {
        Partie partie = new Partie();
        partie.setId( resultSet.getLong( "id" ) );
        partie.setId_jeu(resultSet.getLong("Jeu_id"));
        partie.setId_utilisateur(resultSet.getLong("Utilisateur_id"));
        partie.setDatedebut(resultSet.getTimestamp("date_debut"));
        partie.setDatefin(resultSet.getTimestamp("date_fin"));
        partie.setEnCours(resultSet.getBoolean("enCours"));

        return partie;
    }

}
