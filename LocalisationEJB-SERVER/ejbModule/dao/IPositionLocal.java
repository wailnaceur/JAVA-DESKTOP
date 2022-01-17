package dao;

import java.util.List;

import javax.ejb.Local;


import entities.Position;

@Local
public interface IPositionLocal {
    
	public boolean ajouter(Position obj);
	public boolean modifier(Position obj);
	public boolean supprimer(Position obj);
	public Position findById(int id);
	public List<Position> findAll();
	
	
}
