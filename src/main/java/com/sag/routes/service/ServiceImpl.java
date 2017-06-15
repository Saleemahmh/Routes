package com.sag.routes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sag.routes.dao.Dao;
import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;
import com.sag.routes.model.TrainDetailDTO;
import com.sag.routes.model.TrainDetails;

//Service Implementation for route and bus service with the Annotation @Service
@Service
public class ServiceImpl implements ServiceI {

	// Route Service Implementation

	@Autowired
	private Dao dao;

	@Override
	public Route getRouteById(int routeId) {
		Route obj = dao.getRouteById(routeId);
		return obj;
	}

	@Override
	public List<Route> getAllRoutes() {
		return dao.getAllRoutes();
	}

	@Override
	public synchronized boolean addRoute(Route route) {
		if (dao.routeExists(route.getSource(), route.getDestination())) {
			return false;
		} else {
			dao.addRoute(route);
			return true;
		}
	}

	@Override
	public void updateRoute(Route route) {
		dao.updateRoute(route);
	}

	@Override
	public void deleteRoute(int routeId) {
		dao.deleteRoute(routeId);
	}

	@Override
	public List<RouteDTO> getBusRoute(String source, String destination) {
		List<Object> busRoute = dao.getBusRoute(source, destination);
		List<RouteDTO> routelist = new ArrayList<>();
		for (Object obj : busRoute) {
			Object[] objArray = (Object[]) obj;
			RouteDTO routedto = new RouteDTO();
			routedto.setSource(String.valueOf(objArray[0]));
			routedto.setDestination(String.valueOf(objArray[1]));
			routedto.setRoute_Num(String.valueOf(objArray[2]));
			routelist.add(routedto);
		}
		return routelist;

	}

	// Bus Service Implementation

	@Override
	public BusDetails getBusDetailsById(int busDetailsId) {
		BusDetails obj = dao.getBusDetailsById(busDetailsId);
		return obj;
	}

	@Override
	public List<BusDetails> getAllBusDetails() {
		return dao.getAllBusDetails();
	}

	@Override
	public synchronized boolean addBusDetails(BusDetails busDetails) {
		if (dao.busDetailsExists(busDetails.getRoute_Num())) {
			return false;
		} else {
			dao.addBusDetails(busDetails);
			return true;
		}
	}

	@Override
	public void updateBusDetails(BusDetails busDetails) {
		dao.updateBusDetails(busDetails);
	}

	@Override
	public void deleteBusDetails(int busDetailsId) {
		dao.deleteBusDetails(busDetailsId);
	}

	// Train Service Implementation

	@Override
	public TrainDetails getTrainDetailsById(int trainId) {
		
		TrainDetails obj = dao.getTrainDetailsById(trainId);
		return obj;
	}

	@Override
	public List<TrainDetailDTO> getAllTrainDetails() {
		List<Object> trainRoute = dao.getAllTrainDetails();
		List<TrainDetailDTO> trainlist = new ArrayList<>();
		for (Object obj : trainRoute) {
			Object[] objArray = (Object[]) obj;
			TrainDetailDTO traindto = new TrainDetailDTO();
			traindto.setSource(String.valueOf(objArray[0]));
			traindto.setDestination(String.valueOf(objArray[1]));
			traindto.setRoute(String.valueOf(objArray[2]));
			String hms = getTimeInString(Long.valueOf(String.valueOf(objArray[3])));
			traindto.setTime(hms);
			traindto.setType(String.valueOf(objArray[4]));
			trainlist.add(traindto);
		}

		return trainlist;

		
	}

	@Override
	public synchronized boolean addTrainDetails(TrainDetails trainDetails) {
		if (dao.trainDetailsExists(trainDetails.getSource(), trainDetails.getDestination(), trainDetails.getRoute(),
				trainDetails.getTime(), trainDetails.getType())) {
			return false;
		} else {
			dao.addTrainDetails(trainDetails);
			return true;
		}
	}

	@Override
	public void updateTrainDetails(TrainDetails trainDetails) {
		dao.updateTrainDetails(trainDetails);
	}

	@Override
	public void deleteTrainDetails(int trainId) {
		dao.deleteTrainDetails(trainId);
	}

	@Override
	public List<TrainDetailDTO> getTrainRoute(String source, String destination) {
		List<Object> trainRoute = dao.getTrainRoute(source, destination);
		List<TrainDetailDTO> trainlist = new ArrayList<>();
		for (Object obj : trainRoute) {
			Object[] objArray = (Object[]) obj;
			TrainDetailDTO traindto = new TrainDetailDTO();
			traindto.setSource(String.valueOf(objArray[0]));
			traindto.setDestination(String.valueOf(objArray[1]));
			traindto.setRoute(String.valueOf(objArray[2]));
			String hms = getTimeInString(Long.valueOf(String.valueOf(objArray[3])));
			traindto.setTime(hms);
			traindto.setType(String.valueOf(objArray[4]));
			trainlist.add(traindto);
		}

		return trainlist;

	}
	//To convert given long time which is given in millisecond to hour
	public String getTimeInString(long obj) {
		String hms =String.format("%02d:%02d",TimeUnit.MILLISECONDS.toHours(obj),
				TimeUnit.MILLISECONDS.toSeconds(obj) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(obj)));
		return hms;
	}
}
