package com.sag.routes.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.TrainDetails;

/*DAO Implementation For Route and Bus Dao with the Annotation @Repository
*@Transactional for database transaction
*@PersistenceContext inject an Entity Manager into the DAO class.
*/

@Transactional
@Repository
public class DaoImpl implements Dao {

	/*Entity Manager is used to access a database 
	* it is used to create and remove persistent entity instances
	*to find entities by their primary key identity etc. 
	*This interface is similar to the Session in Hibernate
	*/
	@PersistenceContext
	private EntityManager entityManager;

	// Route DAO Implementation
	
	
	@Override
	public Route getRouteById(int routeId) {
		return entityManager.find(Route.class, routeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> getAllRoutes() {
		String hql = "FROM Route as rte ORDER BY rte.route_id";
		return (List<Route>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addRoute(Route route) {
		entityManager.persist(route);
	}

	@Override
	public void updateRoute(Route route) {
		Route rte = entityManager.find(Route.class, route.getRoute_id());
		rte.setSource(route.getSource());
		rte.setDestination(route.getDestination());
		entityManager.flush();
	}

	@Override
	public void deleteRoute(int routeId) {
		entityManager.remove(entityManager.find(Route.class, routeId));
	}

	@Override
	public boolean routeExists(String source, String destination) {
		String hql = "FROM Route as rte WHERE rte.source = ? and rte.destination = ?";
		int count = entityManager.createQuery(hql).setParameter(1, source).setParameter(2, destination).getResultList()
				.size();
		return count > 0;
	}

	
	/* Query for the function in PostgreSQL which is written in Hibernate and stored in 'hql'
	 * ----->SELECT source,destination,route_Num FROM route AS r INNER JOIN
	* busroute_details AS brd ON brd.route_id=r.route_id
	* INNER JOIN busdetails AS bd ON brd.busdetails_id=bd.busdetails_id
	* WHERE r.source='TNagar' AND r.destination='Thiruvanmiyur';
	*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getBusRoute(String source, String destination) {
		System.out.println(source + destination);
		String hql = "select rte.source,rte.destination,bd.route_Num FROM Route as rte INNER JOIN rte.busroutedetails as brd INNER JOIN brd.busdetails as bd where rte.source = '"
				+ source.toLowerCase() + "' and rte.destination =  '" + destination.toLowerCase() + "'";
		return (List<Object>) entityManager.createQuery(hql).getResultList();

		

	}
	
	// Bus DAO Implementation
	
	@Override
	public BusDetails getBusDetailsById(int busDetailsId) {
		return entityManager.find(BusDetails.class, busDetailsId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusDetails> getAllBusDetails() {
		String hql = "FROM BusDetails as rte ORDER BY rte.busDetails_id";
		return (List<BusDetails>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addBusDetails(BusDetails busDetails) {
		entityManager.persist(busDetails);
	}

	@Override
	public void updateBusDetails(BusDetails busDetails) {
		BusDetails rte = entityManager.find(BusDetails.class, busDetails.getBusDetails_id());
		rte.setRoute_Num(busDetails.getRoute_Num());
		entityManager.flush();
	}

	@Override
	public void deleteBusDetails(int busDetailsId) {
		entityManager.remove(entityManager.find(BusDetails.class, busDetailsId));
	}

	@Override
	public boolean busDetailsExists(String route_Num) {
		String hql = "FROM BusDetails as rte WHERE rte.route_Num = ?";
		int count = entityManager.createQuery(hql).setParameter(1, route_Num).getResultList().size();
		return count > 0 ;
	}
	
	// TrainDetails  DAO Implementation
	
	
		@Override
		public TrainDetails getTrainDetailsById(int trainId) {
			return entityManager.find(TrainDetails.class, trainId);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<TrainDetails> getAllTrainDetails() {
			String hql = "FROM TrainDetails as trn ORDER BY trn.trainId";
			return (List<TrainDetails>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addTrainDetails(TrainDetails trainDetails) {
			entityManager.persist(trainDetails);
		}

		@Override
		public void updateTrainDetails(TrainDetails trainDetails) {
			TrainDetails trn = entityManager.find(TrainDetails.class, trainDetails.getTrainId());
			trn.setSource(trainDetails.getSource());
			trn.setDestination(trainDetails.getDestination());
			trn.setTime(trainDetails.getTime());
			trn.setRoute(trainDetails.getRoute());
			entityManager.flush();
		}

		@Override
		public void deleteTrainDetails(int trainId) {
			entityManager.remove(entityManager.find(TrainDetails.class, trainId));
		}

		@Override
		public boolean trainDetailsExists(String source, String destination,String route,Timestamp time) {
			String hql = "FROM TrainDetails as trn WHERE trn.source = ? and trn.destination = ? and trn.route = ?and trn.time = ?";
			int count = entityManager.createQuery(hql).setParameter(1, source).setParameter(2, destination).setParameter(3,route ).setParameter(4, time).getResultList()
					.size();
			return count > 0;
		}

		
		/* Query for the function in PostgreSQL which is written in Hibernate and stored in 'hql'
		 * ----->SELECT source,destination,route_Num FROM route AS r INNER JOIN
		* busroute_details AS brd ON brd.route_id=r.route_id
		* INNER JOIN busdetails AS bd ON brd.busdetails_id=bd.busdetails_id
		* WHERE r.source='TNagar' AND r.destination='Thiruvanmiyur';
		*/
		
		@SuppressWarnings("unchecked")
		@Override
		public List<TrainDetails> getTrainRoute(String source, String destination) {
			System.out.println(source + destination);
			String hql = "FROM TrainDetails as trn where trn.source = '"
					+ source.toLowerCase() + "' and trn.destination =  '" + destination.toLowerCase() + "'";
			return (List<TrainDetails>) entityManager.createQuery(hql).getResultList();

			

		}
	
}
