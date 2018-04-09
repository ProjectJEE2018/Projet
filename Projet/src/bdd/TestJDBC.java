package bdd;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestJDBC {
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();

    public List<String> executerTests( HttpServletRequest request ) {
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/projet";
        String utilisateur = "java";
        String motDePasse = "root";
        java.sql.Connection connexion = null;
        java.sql.Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery( "SELECT id, email, nom, date_inscription, naissance FROM Utilisateur;" );
            
     
            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                int idUtilisateur = resultat.getInt( "id" );
                String emailUtilisateur = resultat.getString( "email" );
                String naissanceUtilisateur = resultat.getString( "naissance" );
                String nomUtilisateur = resultat.getString( "nom" );
                String inscripUtilisateur = resultat.getString( "date_inscription" );

                /* Formatage des données pour affichage dans la JSP finale. */
                messages.add( " id : " + idUtilisateur + ", email : " + emailUtilisateur
                        + ", date d'inscitption : "
                        + inscripUtilisateur + ", pseudo : " + nomUtilisateur + ", date de naissance : "+ naissanceUtilisateur + "." );
            }
        } catch ( SQLException e ) {
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } finally {

            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
     
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
        
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return messages;
    }
}