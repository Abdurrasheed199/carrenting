package com.rent.carrenting.controllers;

import com.rent.carrenting.models.Role;
import com.rent.carrenting.repository.BookingRepository;
import com.rent.carrenting.repository.CarRepository;
import com.rent.carrenting.repository.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController {

    final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/roles/list", method = RequestMethod.GET)
    public String roles(Model model){
        model.addAttribute("roles", roleRepository.findAll());
        return "role/list";
    }

    @GetMapping("/roles/create")
    public String create(Model model){
        return "role/list";
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam String name, @RequestParam String description ) {

        Role role = new Role(name, description);
        roleRepository.save(role);
        return "redirect:/roles/list";
    }

    @RequestMapping(value = "/roles/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("role", roleRepository.findById(id).get());
        return "role/edit";
    }

    @RequestMapping(value = "/roles/update", method = RequestMethod.POST)
    public String updateRole(Model model, @RequestParam int id, @RequestParam String name) {

        Role role= roleRepository.findById(id).get();
        role.setName(name);

        roleRepository.save(role);

        return "redirect:/roles/list";
    }

    @RequestMapping(value = "/roles/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Role role = roleRepository.findById(id).get();

        roleRepository.delete(role);
        return "redirect:/roles/list";
    }

}
