package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, mot_de_passe, date_inscription, naissance FROM Utilisateur WHERE email = ?";
    private static final String SQL_INSERT           = "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription, naissance) VALUES (?, ?, ?, NOW(), ?)";
    private static final String SQL_DELETE 			 = " DELETE FROM Utilisateur WHERE nom = ? ";
    private static final String SQL_SIGNIN			 ="SELECT COUNT(*) FROM Utilisateur WHERE email = ? and mot_de_passe= ?";
    
    private DAOFactory          daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        return trouver( SQL_SELECT_PAR_EMAIL, email );
    }
    
    public Utilisateur signin( String email, String mdp) throws DAOException {
        return signin( SQL_SIGNIN, email, mdp );
    }
    
    public void supprimer( String nom ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE, true, nom );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du compte, aucune ligne supprimée de la table." );
            } else {
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }
    

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getNom(), utilisateur.getNaissance());
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                utilisateur.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /*
     * Méthode générique utilisée pour retourner un utilisateur depuis la base
     * de données, correspondant à la requête SQL donnée prenant en paramètres
     * les objets passés en argument.
     */
    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement une adresse email) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;
    }
    
    private Utilisateur signin( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement une adresse email) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( resultSet.getLong( "id" ) );
        utilisateur.setEmail( resultSet.getString( "email" ) );
        utilisateur.setMotDePasse( resultSet.getString( "mot_de_passe" ) );
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setDateInscription( resultSet.getTimestamp( "date_inscription" ) );
        utilisateur.setNaissance( resultSet.getString( "naissance" ));
        return utilisateur;
    }

}