package com.hirak.app.carApplication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

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
@Table(name = "Car")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car extends RepresentationModel<Car> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5593084796624697901L;

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
	private String carManufacturingYear;
	
	@Column(name = "car_color")
	private String carColor;

}
