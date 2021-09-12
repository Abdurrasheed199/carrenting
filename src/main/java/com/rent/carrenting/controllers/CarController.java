package com.rent.carrenting.controllers;

import com.rent.carrenting.models.Branch;
import com.rent.carrenting.models.Car;
import com.rent.carrenting.models.Category;
import com.rent.carrenting.models.showmodels.RegisterCarModel;
import com.rent.carrenting.repository.CarRepository;
import com.rent.carrenting.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class CarController {

    final
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public CarController(CarRepository carRepository, CategoryRepository categoryRepository){
        this.carRepository = carRepository;
        this.categoryRepository = categoryRepository;
    }


    private final String UPLOAD_DIR = "C:\\Users\\USER\\Desktop\\FlyRight-New-master\\carrenting\\src\\main\\resources\\static\\uploads";

    @RequestMapping(value = "/cars/list", method = RequestMethod.GET)
    public String cars(Model model){
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("message", "Thank you for Giving Us A Trial...");
        return "car/list";
    }

    @RequestMapping(value = "/cars/availableCars", method = RequestMethod.GET)
    public String availableCars(Model model){
        model.addAttribute("cars", carRepository.findCarsByIsAvailable(true));
        model.addAttribute("message", "Thank you for Giving Us A Trial...");
        return "car/list";
    }

    @RequestMapping(value = "/cars/create", method = RequestMethod.GET)
    public String create(Model model) {
        return "car/create";
    }

    @RequestMapping(value = "/cars/add", method = RequestMethod.POST)
    public String add(Model model, RegisterCarModel registerCarModel) {
        String fileName = "";
        MultipartFile file = registerCarModel.getUrl();
        try {
            //Generate Universally Unique Identifier, convert to string and add it to original name...
            fileName = StringUtils.cleanPath(UUID.randomUUID().toString() + file.getOriginalFilename());
            Path imagePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
            Files.copy(file.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            //throw new FileStorageException("File Not Found");
        }
        Category category = categoryRepository.findByName(registerCarModel.getCategoryName());
        Car car = new Car(registerCarModel.getMake(), registerCarModel.getName(), registerCarModel.getModel(), registerCarModel.getPlateNo(),
                         registerCarModel.getFeatures(), registerCarModel.getBreakdownPrice(),
                         registerCarModel.getBranch(), registerCarModel.getRegistrationNumber(), category, registerCarModel.getPrice(), true, fileName);
        carRepository.save(car);
        return "redirect:/cars/list";
    }

    @RequestMapping(value = "/cars/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("car", carRepository.findById(id).get());
        return "car/edit";
    }

    @RequestMapping(value = "/cars/update", method = RequestMethod.POST)
    public String updateCar(Model model, @RequestParam int id,  @RequestParam String name, @RequestParam String carModel, @RequestParam String plateNo, @RequestParam String features, @RequestParam String breakdownPrice, @RequestParam Branch branch, @RequestParam String carSn, @RequestParam Category category, @RequestParam Double price, @RequestParam Boolean isAvailable, @RequestParam String url) {

        Car car= carRepository.findById(id).get();
        car.setName(name);
        car.setModel(carModel);
        car.setPlateNo(plateNo);
        car.setFeatures(features);
        carRepository.save(car);

        return "redirect:/cars/list";
    }

    @RequestMapping(value = "/cars/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Car car = carRepository.findById(id).get();

        carRepository.delete(car);
        return "redirect:/cars/list";
    }
}


