package dao;

import java.util.List;

import beans.Jeu;

public interface JeuDAO {
	
	void Suppr(String sql) throws DAOException;
	void suppr(String nom);


}