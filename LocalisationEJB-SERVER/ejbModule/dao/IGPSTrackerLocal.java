package dao;

import java.util.List;

import javax.ejb.Local;


import entities.GPSTracker;

@Local
public interface IGPSTrackerLocal  {
	public boolean ajouter(GPSTracker obj);
	public boolean modifier(GPSTracker obj);
	public boolean supprimer(GPSTracker obj);
	public GPSTracker findById(int id);
	public GPSTracker findBySim(String sim);
	public List<GPSTracker> findAll();

}
