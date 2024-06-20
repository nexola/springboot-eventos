package com.univercode.eventos.controllers;

import com.univercode.eventos.entities.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @GetMapping("/create")
    public String home() {
        return "create";
    }

    @PostMapping("/create")
    public void create(Event event) {
        System.out.println("O nome do evento é: " + event.getTitulo());
        System.out.println("A data do evento é: " + event.getData());
        System.out.println("O local do evento é: " + event.getLocal());
        System.out.println("O site do evento é: " + event.getSite());
        System.out.println("O horário do evento é: " + event.getHorario());
    }
}
