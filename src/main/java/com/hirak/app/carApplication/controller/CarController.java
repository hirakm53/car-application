package com.hirak.app.carApplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirak.app.carApplication.dto.CarDto;
import com.hirak.app.carApplication.service.CarServiceImpl;

/**
 * @author hirak_mahanta
 *
 */

@RestController
@RequestMapping("/car")
public class CarController {
	
	private final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarServiceImpl carService;
	
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCars() {
		logger.info("Fetching list of cars API is called");
		List<CarDto> carDtoList = carService.getAllCars();
		if((null != carDtoList) && (!carDtoList.isEmpty()))
			return new ResponseEntity<List<CarDto>>(carDtoList, HttpStatus.OK);
		return new ResponseEntity<String>("No data found!", HttpStatus.NO_CONTENT);
	}

}
