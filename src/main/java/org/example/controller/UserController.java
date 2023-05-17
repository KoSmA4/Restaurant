package org.example.controller;


import org.example.model.Visitor;
import org.example.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    CafeRepository cafeRepository;


    @GetMapping("/authorization")
    public String viewListFeedbacks(Model model){
        List<Visitor> feedbacks = cafeRepository.findAll();
        model.addAttribute("list_feedbacks", feedbacks);
        return "list-feedbacks";
    }



}
