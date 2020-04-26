package com.hirak.app.carApplication.service;

import java.util.List;

import com.hirak.app.carApplication.dto.CarDto;

/**
 * @author hirak_mahanta
 *
 */
public interface CarService {
	
	public List<CarDto> getAllCars();
	
	public String addCars(CarDto carDto);

}
