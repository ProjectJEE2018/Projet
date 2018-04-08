package beans;


import java.io.Serializable;
import java.sql.Date;

public class Partie implements Serializable {
    private Long     id;
    private String jeu;
    private Utilisateur u1;
    private Date datedeb;
    private Date datefin;
   

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public Utilisateur getU1() {
		return u1;
	}

	public void setU1(Utilisateur u1) {
		this.u1 = u1;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

}