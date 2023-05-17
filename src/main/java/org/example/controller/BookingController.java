package org.example.controller;

import org.example.model.Booking;
import org.example.model.Table;
import org.example.model.Visitor;
import org.example.repository.BookingRepository;
import org.example.repository.TableRepository;
import org.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public int stolik;

    @GetMapping("/book")
    public String getBookPage(Model model) {
        List<Table> tables = tableRepository.findAll();
        model.addAttribute("tables", tables);
//        model.addAttribute("booking", new Booking());
        return "table";
    }

    @PostMapping("/book")
    public String postBookPage(@ModelAttribute Booking booking) {

        Table table = tableRepository.findByNumber(booking.getTable().getNumber());
        table.setAccess(false);
        stolik = table.getNumber();
        tableRepository.save(table);
        bookingRepository.save(booking);
        return "redirect:/auto";
    }

    @GetMapping("/auto")
    public String getAutoPage(Model model) {
        model.addAttribute("stolik", stolik);
        return "table__auto";
    }

    @PostMapping("/auto")
    public String postAutoPage(@ModelAttribute Booking booking) {
        Table table = tableRepository.findByNumber(stolik);
        booking.setTable(table);
        bookingRepository.save(booking);
        stolik = 0;
        return "redirect:/";
    }
}
