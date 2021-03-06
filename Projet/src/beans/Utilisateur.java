package beans;

import java.sql.Timestamp;

public class Utilisateur {

	private Long id;
    private String email;
    private String motDePasse;
    private String nom;
    private String naissance;
    private Timestamp dateInscription;
    public boolean admin;
    
    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }

    public void setEmail(String email) {
	this.email = email;
    }
    public String getEmail() {
	return email;
    }

    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
	return motDePasse;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }
    public String getNom() {
	return nom;
    }
    
    public void setNaissance(String naissance) {
	this.naissance = naissance;
    }
    public String getNaissance() {
	return naissance;
    }
    
    public Timestamp getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }
    /* TEST DE BOOLEEN....
     * 
    public boolean isAdmin(){
    	if (email=="admin@amdmin.com"){
    		return true;
    	}else{
    		return false;
    	}
    }
    */
    	
}