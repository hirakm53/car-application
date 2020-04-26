package com.hirak.app.carApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hirak_mahanta
 *
 */
@Entity
@Table(name = "CAR")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	
	@Id
	@Column(name = "car_id")
	@SequenceGenerator(name = "CAR_ID_SQ", sequenceName = "CAR_ID_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_ID_SQ")
	private int carId;
	
	@Column(name = "car_name")
	private String carName;
	
	@Column(name = "car_manufacturer_name")
	private String carManufacturerName;
	
	@Column(name = "car_model")
	private String carModel;
	
	@Column(name = "car_manufacturing_yr")
	private int carManufacturingYear;
	
	@Column(name = "car_color")
	private String carColor;

}
