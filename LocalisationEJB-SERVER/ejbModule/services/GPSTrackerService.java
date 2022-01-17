package services;

import java.rmi.RemoteException;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IGPSTracker;
import dao.IGPSTrackerLocal;
import entities.GPSTracker;

@Stateless(name = "GPS")
public class GPSTrackerService implements IGPSTracker,IGPSTrackerLocal {

	private static final long serialVersionUID = -3043836073909928602L;
	
	@PersistenceContext
	private EntityManager em;
	
	public GPSTrackerService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(GPSTracker obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return true;
	}

	@Override
	public boolean modifier(GPSTracker obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return true;
	}

	@Override
	public boolean supprimer(GPSTracker obj) {
		// TODO Auto-generated method stub
		em.remove(em.contains(obj) ? obj : em.merge(obj));
		return true;
		
	}

	@Override
	public GPSTracker findById(int id) {
		// TODO Auto-generated method stub
		return em.find(GPSTracker.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GPSTracker> findAll() {
		// TODO Auto-generated method stub
		Query qr = em.createQuery("from GPSTracker");
		return qr.getResultList();
	}

	@Override
	public GPSTracker findBySim(String sim) {
		// TODO Auto-generated method stub
		Query qr = em.createQuery("from GPSTracker where simNumber = :gps_sim");
		qr.setParameter("gps_sim",sim);
		return (GPSTracker) qr.getSingleResult();
		
	}

	

}
