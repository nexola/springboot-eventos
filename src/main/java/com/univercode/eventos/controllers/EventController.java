package com.univercode.eventos.controllers;

import com.univercode.eventos.entities.Event;
import com.univercode.eventos.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("evento", new Event());
        return mv;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("eventos", service.findAll());
        return mv;
    }

    @PostMapping("/create")
    public String insert(Event event) {
        if (event.getId() != null) {
            Event entity = service.findById(event.getId());
            entity.setData(event.getData());
            entity.setTitulo(event.getTitulo());
            entity.setLocal(event.getLocal());
            entity.setSite(event.getSite());
            entity.setHorario(event.getHorario());
            entity.setRedes_sociais(event.getRedes_sociais());

            service.insert(entity);
        } else {
            service.insert(event);
        }
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("evento", service.findById(id));
        return mv;
    }
}
