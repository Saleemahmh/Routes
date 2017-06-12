package com.sag.routes.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/*Model class to create traindetails table in PostgreSQL
 * with trainId,source,destination,time,route
 * @Entity-Specifies this class is an entity class
 * @Table Specifies Table and the name of table in DB
*/

@Entity
@Table(name="TRAINDETAILS")
public class TrainDetails {
		@Id
		//specifies this field is primary key
		private Integer trainId;
		@Column
		//specifies the column 
		private String source;
		@Column
		private String destination;
		@Column
		@JsonFormat(pattern = "HH:mm")
		private Timestamp time;
		@Column
		private String route;
		
		
		public TrainDetails() {	}

		
		public TrainDetails(Integer trainId, String source, String destination, Timestamp time, String route) {
			this.trainId = trainId;
			this.source = source;
			this.destination = destination;
			this.time = time;
			this.route = route;
		}


		//Getter and Setters
		public Integer getTrainId() {
			return trainId;
		}

		public void setTrainId(Integer trainId) {
			this.trainId = trainId;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		

		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

		public String getRoute() {
			return route;
		}

		public void setRoute(String route) {
			this.route = route;
		}
		
		
}
