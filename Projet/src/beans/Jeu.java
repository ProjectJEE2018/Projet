package beans;

public class Jeu {
	
	private Long id;
    private String nom;
    
    
    
    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }
    public String getNom() {
	return nom;
    }

}