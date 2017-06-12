package com.sag.routes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sag.routes.dao.Dao;
import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;
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
	public List<TrainDetails> getAllTrainDetails() {
		return dao.getAllTrainDetails();
	}

	@Override
	public synchronized boolean addTrainDetails(TrainDetails trainDetails) {
		if (dao.trainDetailsExists(trainDetails.getSource(),trainDetails.getDestination(),trainDetails.getRoute(),trainDetails.getTime())) {
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
	public List<TrainDetails> getTrainRoute(String source, String destination) {
		List<TrainDetails> trainRoute = dao.getTrainRoute(source, destination);
		
		return trainRoute;

	}

}
