package beans;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Partie implements Serializable {
    private Long id;
    private Long id_jeu;
    private Long id_utilisateur;
    private Timestamp datedebut;
    private Timestamp datefin;
    private boolean enCours;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_jeu() {
		return id_jeu;
	}
	public void setId_jeu(Long id_jeu) {
		this.id_jeu = id_jeu;
	}
	public Long getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Timestamp getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Timestamp datedebut) {
		this.datedebut = datedebut;
	}
	public Timestamp getDatefin() {
		return datefin;
	}
	public void setDatefin(Timestamp datefin) {
		this.datefin = datefin;
	}
	public boolean isEnCours() {
		return enCours;
	}
	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}
    
    
	
	

}