package com.univercode.eventos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class SocialMedia {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Event event;
}
