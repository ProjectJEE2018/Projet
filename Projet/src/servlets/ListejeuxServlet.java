package servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import beans.Jeu;
import beans.Utilisateur;
import dao.JeuDAO;
import form.InscriptionForm;
import form.ModifJeux;

public class ListejeuxServlet extends HttpServlet {
    public static final String VUE     = "/WEB-INF/ListeJeux.jsp";
    public static final String ACCES_RESTREINT  = "/restriction";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_JEU        = "jeu";
    
    private JeuDAO jeuDao;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
 
    	/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
<<<<<<< HEAD
        if ( session.getAttribute( ATT_SESSION_USER ) == "admin@admin.com") {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_LISTE );
=======
        
        /*Utilisateur test = new Utilisateur();
        test.setEmail("admin@admin.com");
        test.setId((long) 3);
        test.setMotDePasse("admin");
        test.setNom("admin");*/
        
        if ( session.getAttribute( ATT_SESSION_USER ) != null) {
            /* Redirection vers la page admin */
        	 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
      
>>>>>>> fce464534edc464ccd98460dbcc8e61d68e156d0
        } else {
            /* Affichage de la page restreinte ou public */
        	
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
        }
        
        
    }
    

    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 /* Préparation de l'objet formulaire */
        ModifJeux form = new ModifJeux( jeuDao );

        /* Traitement de la requête et récupération du bean en résultant */
        Jeu jeu = form.creerJeu( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_JEU, jeu );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
}