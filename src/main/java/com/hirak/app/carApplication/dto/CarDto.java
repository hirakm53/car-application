package com.hirak.app.carApplication.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hirak_mahanta
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3766642374132583156L;
	
	@JsonProperty("car_id")
	private int carId;
	
	@JsonProperty("car_name")
	private String carName;
	
	@JsonProperty("car_manufacturer_name")
	private String carManufacturerName;
	
	@JsonProperty("car_model")
	private String carModel;
	
	@JsonProperty("car_manufacturing_year")
	private int carManufacturingYear;
	
	@JsonProperty("car_color")
	private String carColor;

}
