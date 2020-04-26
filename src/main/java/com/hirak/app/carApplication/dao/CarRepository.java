package com.hirak.app.carApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirak.app.carApplication.model.Car;

/**
 * @author hirak_mahanta
 *
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	public List<Car> findAll();

}
