package com.filip.springbootjava8and10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

@Controller
public class PagesController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/objects")
    public String getDates(Model model) {
        model.addAttribute("date", new Date());
        model.addAttribute("calendar", Calendar.getInstance());
        model.addAttribute("num", Math.random() * 10);
        model.addAttribute("string", "new text");
        model.addAttribute("emptyString", "");
        model.addAttribute("nullString", null);
        model.addAttribute("array", new int[]{1, 3, 4, 5});
        model.addAttribute("set", new HashSet<Integer>(Arrays.asList(1, 3, 8)));
        return "pages/objects";
    }


    @GetMapping(value = "/dates")
    public String getInfo(Model model) {
        model.addAttribute("standardDate", new Date());
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("timestamp", Instant.now());
        return "pages/dates";
    }

}
