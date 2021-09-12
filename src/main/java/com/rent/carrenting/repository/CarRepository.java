package com.rent.carrenting.repository;

import com.rent.carrenting.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {
    Car findByRegistrationNumber(String registrationNumber);
    List<Car> findCarsByIsAvailable(boolean isAvailable);
    List<Car> findCarsByCategoryId(int id);
}
