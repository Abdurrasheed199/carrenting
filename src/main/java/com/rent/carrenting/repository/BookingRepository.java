package com.rent.carrenting.repository;

import com.rent.carrenting.models.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
    Booking findBookingsByUserId(long id);
}
