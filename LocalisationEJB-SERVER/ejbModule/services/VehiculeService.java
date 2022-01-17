package services;

import java.rmi.RemoteException;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IVehicule;
import dao.IVehiculeLocal;
import entities.Vehicule;

@Stateless(name = "VEH")
public class VehiculeService implements IVehicule,IVehiculeLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6543015107542840056L;
	/**
	 * 
	 */
	

	@PersistenceContext
	private EntityManager em;

	public VehiculeService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(Vehicule obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return true;
	}

	@Override
	public boolean modifier(Vehicule obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return true;
	}

	@Override
	public boolean supprimer(Vehicule obj) {
		// TODO Auto-generated method stub
		em.remove(em.contains(obj) ? obj : em.merge(obj));
		return true;
	}

	@Override
	public Vehicule findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Vehicule.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		Query qr = em.createQuery("from Vehicule");
		return qr.getResultList();
	}

}
