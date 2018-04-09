package servlets;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import bdd.TestJDBC;

public class GestionTestJDBC extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/WEB-INF/test_jdbc.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	/* Connexion à la base de données */
    	String url = "jdbc:mysql://localhost:3306/root";
    	String utilisateur = "java";
    	String motDePasse = "root";
    	java.sql.Connection connexion = null;
    	try {
    	    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
    	   ;
    	    /* Ici, nous placerons nos requêtes vers la BDD */
    	    /* ... */

    	} catch ( SQLException e ) {
    	    /* Gérer les éventuelles erreurs ici */
    	} finally {
    	    if ( connexion != null )
    	        try {
    	            /* Fermeture de la connexion */
    	            connexion.close();
    	        } catch ( SQLException ignore ) {
    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
    	        }
    	}
    	
    	/* Initialisation de l'objet Java et récupération des messages */
        TestJDBC test = new TestJDBC();
        List<String> messages = test.executerTests( request );

        /* Enregistrement de la liste des messages dans l'objet requête */
        request.setAttribute( ATT_MESSAGES, messages );

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}