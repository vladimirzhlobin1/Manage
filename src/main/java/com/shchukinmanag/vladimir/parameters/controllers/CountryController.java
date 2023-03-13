package com.shchukinmanag.vladimir.parameters.controllers;

import com.shchukinmanag.vladimir.parameters.models.Country;
import com.shchukinmanag.vladimir.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

@GetMapping("/countries")
    public String getAll(Model model){
   List<Country> countries= countryService.getAll();
   model.addAttribute("countries", countries);
    return "parameters/countryList";
    }

    @GetMapping("/countryAdd")
        public String addCountry (){
return "/parameters/countryAdd";
        }

    @GetMapping("/countryDetails/{id}")
    public String detailsCountry (@PathVariable Integer id, Model model){
    Country country = countryService.getById(id);
    model.addAttribute("country", country);
        return "/parameters/countryDetails";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry (@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "/parameters/countryEdit";
    }

        @PostMapping("/countries")
    public String save (Country country){
    countryService.save(country);
    return "redirect:/countries";
        }
@RequestMapping(value = "/countries/delete/{id}",method = {RequestMethod.GET, RequestMethod.DELETE})
        public String delete (@PathVariable Integer id){
    countryService.delete(id);
    return "redirect:/countries";
        }

    @RequestMapping(value = "/countries/update/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public String delete (Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

}
