package com.hirak.app.carApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirak.app.carApplication.dao.CarRepository;
import com.hirak.app.carApplication.dto.CarDto;
import com.hirak.app.carApplication.model.Car;

/**
 * @author hirak_mahanta
 *
 */
@Service
public class CarServiceImpl implements CarService {
	
	private final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	
	@Autowired
	private CarRepository carRepo;

	@Override
	public List<CarDto> getAllCars() {
		List<Car> carsList = carRepo.findAll();
		List<CarDto> carDtoList = null;
		if(!carsList.isEmpty() && (null != carsList)) {
			logger.info("List of cars are " + carsList.toString());
			carDtoList = carsList.stream().map(cars -> {
				CarDto carDto = new CarDto();
				carDto.setCarId(cars.getCarId());
				carDto.setCarName(cars.getCarName());
				carDto.setCarManufacturerName(cars.getCarManufacturerName());
				carDto.setCarModel(cars.getCarModel());
				carDto.setCarManufacturingYear(cars.getCarManufacturingYear());
				carDto.setCarColor(cars.getCarColor());
				return carDto;
			}).collect((Collectors.toList()));			
		}
		return carDtoList;
	}

	@Override
	public String addCars(CarDto carDto) {
		Integer res = carRepo.save(carDto.getCarName(), carDto.getCarManufacturerName(), carDto.getCarModel(), carDto.getCarManufacturingYear(), carDto.getCarColor());
		logger.info("Result is " + res);
		if(res == 1)
			return "Successfully created a new entry";
		else
			return "Failed to create a new entry";
	}

	@Override
	public String updateCars(CarDto carDto) {
		Car car = carRepo.findById(carDto.getCarId());
		Integer res = 0;
		if(null != car) {
			res = carRepo.update(carDto.getCarId(), carDto.getCarName(), carDto.getCarManufacturerName(), carDto.getCarModel(), carDto.getCarManufacturingYear(), carDto.getCarColor());
		} else {
			return "No data available for the provided id";
		}
		if(res == 1)
			return "Successfully updated the entry";
		else
			return "Failed to update the entry";
	}

}
