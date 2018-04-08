package dao;

import java.util.List;

import beans.Jeu;

public interface JeuDAO {
	
	static void Suppr(String sql) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	void suppr(String nom);
<<<<<<< HEAD
	void creer( Jeu jeu ) throws DAOException;
=======
	static void creer( Jeu jeu ) throws DAOException {
		// TODO Auto-generated method stub
		
	}
>>>>>>> f03fe7f445482b074eb6ee1b6a1d8fb034f3daee


}