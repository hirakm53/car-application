package com.hirak.app.carApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hirak.app.carApplication.dto.CarDto;
import com.hirak.app.carApplication.service.CarServiceImpl;

/**
 * @author hirak_mahanta
 *
 */
@RestController
@RequestMapping("/")
public class CarController {
	
	private final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarServiceImpl carService;
	
	@GetMapping(path = "/car/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCars() {
		logger.info("Fetching list of cars API is called");
		List<CarDto> carDtoList = carService.getAllCars();
		if((null != carDtoList) && (!carDtoList.isEmpty()))
			return new ResponseEntity<List<CarDto>>(carDtoList, HttpStatus.OK);
		return new ResponseEntity<String>("No data found!", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path = "/car", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCars(@RequestBody @Valid CarDto carDto) {
		logger.info("Adding new entry of cars API is called");
		String msg = null;
		if(null != carDto)
			msg = carService.addCars(carDto);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCars(@RequestBody @Valid CarDto carDto) {
		logger.info("Updating entry of cars API is called");
		String msg = null;
		if(null != carDto)
			msg = carService.updateCars(carDto);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/car")
	public ResponseEntity<?> deleteCars(@RequestParam("carId") int carId) {
		logger.info("Deleting entry of cars API is called");
		String msg = carService.removeCars(carId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
