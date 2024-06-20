package com.univercode.eventos.dtos;

import com.univercode.eventos.entities.Event;
import lombok.Data;

import java.util.List;

public @Data class EventDTO {
    private Long id;
    private String data;
    private String titulo;
    private String local;
    private String site;
    private String horario;
    private String redes_sociais;

    public EventDTO(Event entity) {
        this.id = entity.getId();
        this.data = entity.getData().toString();
        this.titulo = entity.getTitulo();
        this.local = entity.getLocal();
        this.site = entity.getSite();
        this.horario = entity.getHorario().toString();
        this.redes_sociais = entity.getRedes_sociais();
    }
}
