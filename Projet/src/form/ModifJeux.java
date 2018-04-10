package form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Jeu;
import dao.DAOException;
import dao.JeuDAO;
import dao.UtilisateurDao;

public class ModifJeux {
	private List<String> messages = new ArrayList<String>();
	private static final String CHAMP_JEU_NOM   = "nom";
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private JeuDAO      jeuDao;
	    
	    public ModifJeux( JeuDAO jeuDao ) {
	        this.jeuDao = jeuDao;
	    }
	    
	    public String getResultat() {
	        return resultat;
	    }

	    public Map<String, String> getErreurs() {
	        return erreurs;
	    }
	
	    public Jeu creerJeu( HttpServletRequest request ) {	 
	    	// Récupération du formulaire :
	        String nom = getValeurChamp( request, CHAMP_JEU_NOM );
	        
	        Jeu jeu = new Jeu();
	        
	        try {
	            if ( erreurs.isEmpty() ) {
	                jeuDao.creer( jeu );
	                resultat = "Succès de l'ajout.";
	            } else {
	                resultat = "Échec de l'ajout.";
	            }
	        } catch ( DAOException e ) {
	            resultat = "Échec de l'ajout : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
	            e.printStackTrace();
	        }

	        return jeu;
	    }
	     
	    public void suppJeu( HttpServletRequest request) {
	    	String nom = getValeurChamp( request, CHAMP_JEU_NOM);
	    	  
	    	try {
	    		if ( erreurs.isEmpty() ) {
	    			jeuDao.Suppr( nom );
	    			resultat = "Succès de la suppression.";
		        } else {
		        	resultat = "Échec de la suppression.";
		            }
		        } catch ( DAOException e ) {
		            resultat = "Échec de la suppression : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
		            e.printStackTrace();
		        }
	    }
	    
	    
	    /*
	     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}