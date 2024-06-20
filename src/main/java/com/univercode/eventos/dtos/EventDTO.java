package com.univercode.eventos.dtos;

import com.univercode.eventos.entities.Event;
import com.univercode.eventos.entities.SocialMedia;
import lombok.Data;

import java.util.List;

public @Data class EventDTO {
    private Long id;
    private String data;
    private String titulo;
    private String local;
    private String site;
    private String horario;
    private List<SocialMediaDTO> redes_sociais;

    public EventDTO(Event entity) {
        this.id = entity.getId();
        this.data = entity.getData().toString();
        this.titulo = entity.getTitulo();
        this.local = entity.getLocal();
        this.site = entity.getSite();
        this.horario = entity.getHorario().toString();

        for (SocialMedia socialMedia : entity.getRedesSociais()) {
            this.redes_sociais.add(new SocialMediaDTO(socialMedia));
        }
    }
}
