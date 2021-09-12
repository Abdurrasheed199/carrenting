package com.rent.carrenting.controllers;

import com.rent.carrenting.models.*;
import com.rent.carrenting.models.showmodels.RegisterBookingModel;
import com.rent.carrenting.models.showmodels.RegisterBranchModel;
import com.rent.carrenting.models.showmodels.RegisterCarModel;
import com.rent.carrenting.models.showmodels.RegisterUserModel;
import com.rent.carrenting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.UUID;

@Controller
public class BookingController {

    final
    BookingRepository bookingRepository;

    final
    CarRepository carRepository;

    final
    UserRepository userRepository;

    final
    BranchRepository branchRepository;

    final
    PaymentRepository paymentRepository;

    public BookingController(BookingRepository bookingRepository, CarRepository carRepository, UserRepository userRepository, BranchRepository branchRepository, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping(value = "/bookings/list", method = RequestMethod.GET)
    public String bookings(Model model){
        model.addAttribute("bookings", bookingRepository.findAll());
        return "booking/list";
    }

    @RequestMapping(value = "/Bookings/bookCar/{id}", method = RequestMethod.GET)
    public String create(@PathVariable("id") int id, Model model) {

        model.addAttribute("car", carRepository.findById(id).get());
        return "booking/bookCar";
    }

    public String generateUniqueId() {
        UUID uuid = UUID.randomUUID(); //instance of random class
        //generate random values from 0-100000
        int variant = uuid.variant();
        //int version = uuid.version();
        //int num = uuid.nextInt(100000);
        String uniqueId = ("00" + Integer.toString(variant));
        return uniqueId;
    }

    @RequestMapping(value = "/bookings/process", method = RequestMethod.POST)
    public String processBooking(Model model, @RequestParam int id, @RequestParam Branch branch, @RequestParam User user, @RequestParam Booking booking, @RequestParam String reference, @RequestParam Double amount, @RequestParam Boolean paid) {

        Car car = carRepository.findById(id).get();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        /*Payment payment = new Payment(user, booking, reference, amount, date, paid);*/
        return "redirect:/bookings/list";
    }

    @GetMapping("bookings/user{id}")
    public String user(@PathVariable("id") long id, Model model){
        model.addAttribute("cars", bookingRepository.findBookingsByUserId(id));
        return "redirect:/bookings/list";
    }

    @RequestMapping(value = "/bookings/status", method = RequestMethod.POST)
    public String add(Model model, @RequestParam long id, Authentication authentication,  @RequestParam Double amount,
                      RedirectAttributes redirectAttributes, RegisterBookingModel registerBookingModel,
                      RegisterCarModel registerCarModel, RegisterBranchModel registerBranchModel) {

        String userName = authentication.getName();
        var u = userRepository.findByUsername(userName).get();

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Car car = carRepository.findByRegistrationNumber(registerCarModel.getName());
        Booking b = new Booking();

        /*if(!car.getIsAvailable()){
            redirectAttributes.addAttribute("sorry",  "Sorry Car Is not Available");
        }        */

        /*long millis = System.currentTimeMillis();
        Date date = new Date(millis);*/
       car.setIsAvailable(false);
       Branch d = branchRepository.findBranchesByName(registerBranchModel.getName());
       b.setBranch(d);
       b.setCar(car);
       b.setBookingNumber(generateUniqueId());
       b.setBookingDate(date);
       b.setBookingRef(generateUniqueId());
       b.setUser(u);

       carRepository.save(car);
       bookingRepository.save(b);
       Payment payment = new Payment(u, b, generateUniqueId(), amount, date, true);
       paymentRepository.save(payment);

        return "booking/status";
    }

}
