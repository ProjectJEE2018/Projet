package dao;

import beans.Partie;

public interface PartieDao {
	void creer( Partie partie ) throws DAOException; 
	/*Terminer une partie en cours*/
	void terminerPartie ( Partie partie ) throws DAOException; 

}
	