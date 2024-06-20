package com.univercode.eventos.controllers;

import com.univercode.eventos.dtos.EventDTO;
import com.univercode.eventos.entities.Event;
import com.univercode.eventos.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("eventos", service.findAll());

        return mv;

    }

    @PostMapping("/create")
    public String insert(Event event) {
        service.insert(event);

        return "redirect:list";
    }
}
