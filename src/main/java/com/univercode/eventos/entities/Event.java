package com.univercode.eventos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data class Event {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String titulo;
    private String local;
    private String site;
    private LocalTime horario;

    @OneToMany(mappedBy = "event")
    private List<SocialMedia> redesSociais = new ArrayList<>();

    public Event(){}

}
