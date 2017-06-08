package com.sag.routes.service;

import java.util.List;

import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;

// Service Interface

public interface ServiceI {

	// Route Service
	// Get all available routes
	List<Route> getAllRoutes();

	// Get routes based on ID
	Route getRouteById(int routeId);

	// Get Bus route number for given source and destination
	public List<RouteDTO> getBusRoute(String source, String destination);

	boolean addRoute(Route route);

	void updateRoute(Route route);

	void deleteRoute(int routeId);

	// Bus Service
	// Get all available bus number
	List<BusDetails> getAllBusDetails();

	// Get bus number based on ID
	BusDetails getBusDetailsById(int busDetailsId);

	boolean addBusDetails(BusDetails busDetails);

	void updateBusDetails(BusDetails busDetails);

	void deleteBusDetails(int busDetailsId);
}
