package com.hirak.app.carApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hirak.app.carApplication.config.DatasourceConfiguration;
import com.hirak.app.carApplication.model.Car;

/**
 * @author hirak_mahanta
 *
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY, transactionManager = DatasourceConfiguration.TX_MANAGER)
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	@Transactional
	public List<Car> findAll();
	
	@Modifying
	@Transactional
	@Query(value = "insert into Car(car_name, car_manufacturer_name, car_model, car_manufacturing_yr, car_color) VALUES(:name, :manufacturerName, :model, :year, :color)", nativeQuery = true)
	public Integer save(@Param("name") String name, @Param("manufacturerName") String manufacturerName, @Param("model") String model, @Param("year") int year, @Param("color") String color);
	
	@Transactional
	public Car findById(int id);
	
	@Transactional
	@Modifying
	@Query("update Car set carName =:name, carManufacturerName =:manufacturerName, carModel =:model, carManufacturingYear =:year, carColor =:color where carId =:id")
	public Integer update(@Param("id") int id, @Param("name") String name, @Param("manufacturerName") String manufacturerName, @Param("model") String model, @Param("year") int year, @Param("color") String color);

}
