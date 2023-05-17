package org.example.controller;


import org.example.model.Visitor;
import org.example.service.CafeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class CafeController {

    private final CafeService cafeService;


    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }


    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/pizza")
    public String getPizzaPage(){
        return "pizza";
    }

    @GetMapping("/drinks")
    public String getDrinksPage(){
        return "drinks";
    }

    @GetMapping("/salad")
    public String getSaladPage(Model model){
        model.addAttribute("registerRequest", new Visitor());
        return "salad";
    }

    @GetMapping("/restaurant")
    public String getRestPage(){
        return "index";
    }

    @GetMapping("/index_message")
    public String getRegPage(){
        return "index__message";
    }

    @PostMapping("/index_message")
    public String register(@ModelAttribute Visitor visitor){
        Visitor newVisitor = cafeService.createFeedback(
                visitor.getName(),
                visitor.getEmail(),
                visitor.getRate(),
                visitor.getFeedback());
        return newVisitor == null ? "Error" : "redirect:/";
    }
}
