package dao;

import java.util.List;

import beans.Jeu;

public interface JeuDAO {
	
	void Suppr(String sql) throws DAOException;
	void suppr(String nom);
<<<<<<< HEAD
	static void creer( Jeu jeu ) throws DAOException {
		// TODO Auto-generated method stub
		
	}
=======
>>>>>>> fce464534edc464ccd98460dbcc8e61d68e156d0

	void creer( Jeu jeu ) throws DAOException;

}