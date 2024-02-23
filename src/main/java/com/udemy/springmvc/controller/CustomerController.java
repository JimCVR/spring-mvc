package com.udemy.springmvc.controller;

import com.udemy.springmvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/show-customer-form")
    public String showCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/process-customer-form")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customer-form";
        }
        return "customer-confirmation";
    }
}
