package com.univercode.eventos.dtos;

import com.univercode.eventos.entities.SocialMedia;
import lombok.Data;

public @Data class SocialMediaDTO {
    private Long id;
    private String nome;

    public SocialMediaDTO(SocialMedia entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
