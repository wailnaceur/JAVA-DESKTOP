package services;

import java.rmi.RemoteException;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IPosition;
import dao.IPositionLocal;
import entities.Position;

@Stateless(name = "POS")
public class PositionService implements IPosition,IPositionLocal {

	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8294263581668133611L;
	
	public PositionService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public boolean ajouter(Position obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return true;
	}

	@Override
	public boolean modifier(Position obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return true;
	}

	@Override
	public boolean supprimer(Position obj) {
		// TODO Auto-generated method stub
		em.remove(em.contains(obj) ? obj : em.merge(obj));
		return true;
	}

	@Override
	public Position findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Position.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		Query qr = em.createQuery("from Position");
		return qr.getResultList();
	}

}
