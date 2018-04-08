package servlets;

import dao.*;
import beans.Jeu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;


public class ListejeuxServlet extends HttpServlet {
    public static final String ACCES_LISTE     = "/ListeJeux.jsp";
    public static final String ACCES_RESTREINT  = "/WEB-INF/accesRestreint.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == "admin") {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_LISTE );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
        }
    }
    
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String nameSuppr = request.getParameter("nomJeusuppr");
		String nameAdd = request.getParameter("nomJeuadd");

		List<Jeu> ListeJeu = null;

		if (nameSuppr != null && !nameSuppr.equals("")) {
			// suppr
			JeuDAO.Suppr(nameSuppr);
		}
		
		
		if (nameAdd != null && !nameAdd.equals("")) {
			// add
			Jeu j = new Jeu(nameAdd);
			JeuDAO.(nameSuppr);
		}


		// put list in request scope to be retrieved in jsp page
		request.setAttribute("listjeu", ListeJeu);

		// redirect to jsp page
		String pageName = "/accueil.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}