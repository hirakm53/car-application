DROP TABLE IF EXISTS CAR;

CREATE TABLE CAR (
  car_id INT AUTO_INCREMENT PRIMARY KEY,
  car_name VARCHAR(250) NOT NULL,
  car_manufacturer_name VARCHAR(250) NOT NULL,
  car_model VARCHAR(10) NOT NULL,
  car_manufacturing_yr VARCHAR(10) NOT NULL,
  car_color VARCHAR(250) NOT NULL
);

----------------------------------------------------------------------------------------------------------------------------------------------------
