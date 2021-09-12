package com.rent.carrenting.controllers;

import com.rent.carrenting.models.Branch;
import com.rent.carrenting.models.showmodels.RegisterBranchModel;
import com.rent.carrenting.repository.BranchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BranchController {

    final
    BranchRepository branchRepository;

    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @RequestMapping(value = "/branches/list", method = RequestMethod.GET)
    public String warehouses(Model model){
        model.addAttribute("branches", branchRepository.findAll());
        return "branch/list";
    }


    @GetMapping("/branches/create")
    public String create(Model model){
        return "redirect:/branches/list";
    }

    @RequestMapping(value = "/branches/add", method = RequestMethod.POST)
    public String add(Model model, RegisterBranchModel registerBranchModel) {

        Branch b = new Branch();

        b.setName(registerBranchModel.getName());
        b.setAddress(registerBranchModel.getAddress());


        branchRepository.save(b);
        return "redirect:/branches/list";
    }

    @GetMapping("/branches/details/{id}")
    public String warehouseDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("branch", branchRepository.findById(id).get());
        return "branch/details";
    }

    @RequestMapping(value = "/warehouses/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("branch", branchRepository.findById(id).get());
        return "branch/edit";
    }

    @RequestMapping(value = "/warehouses/update", method = RequestMethod.POST)
    public String updateRole(Model model, @RequestParam int id, RegisterBranchModel registerBranchModel) {


        Branch b= branchRepository.findById(id).get();

        b.setName(registerBranchModel.getName());
        b.setAddress(registerBranchModel.getAddress());

        branchRepository.save(b);

        return "redirect:/branches/list";
    }

    @RequestMapping(value = "/branches/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Branch b = branchRepository.findById(id).get();

        branchRepository.delete(b);
        return "redirect:/branches/list";
    }
}
