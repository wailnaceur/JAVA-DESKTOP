package services;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IVehiculeGPSTracker;
import dao.IVehiculeGPSTrackerLocal;
import entities.VehiculeGPSTracker;


@Stateless(name = "VGPSTRACKER")
public class VehiculeGPSTrackerService implements IVehiculeGPSTracker,IVehiculeGPSTrackerLocal {
	@PersistenceContext
	private EntityManager em;

	public VehiculeGPSTrackerService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouter(VehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return true;
	}

	@Override
	public boolean modifier(VehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return true;
	}

	@Override
	public boolean supprimer(VehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		em.remove(em.contains(obj) ? obj : em.merge(obj));
		return true;
	}

	@Override
	public VehiculeGPSTracker findById(int id) {
		// TODO Auto-generated method stub
		return em.find(VehiculeGPSTracker.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiculeGPSTracker> findAll() {
		// TODO Auto-generated method stub
		Query qr = em.createQuery("from VehiculeGPSTracker");
		return qr.getResultList();
	}

}
