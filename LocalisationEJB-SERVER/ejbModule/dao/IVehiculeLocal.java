package dao;

import java.util.List;

import javax.ejb.Local;


import entities.Vehicule;


@Local
public interface IVehiculeLocal  {
	public boolean ajouter(Vehicule obj);
	public boolean modifier(Vehicule obj);
	public boolean supprimer(Vehicule obj);
	public Vehicule findById(int id);
	public List<Vehicule> findAll();
}
