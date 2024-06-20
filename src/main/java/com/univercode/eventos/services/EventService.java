package com.univercode.eventos.services;

import com.univercode.eventos.dtos.EventDTO;
import com.univercode.eventos.entities.Event;
import com.univercode.eventos.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<EventDTO> findAll() {
        List<Event> list = eventRepository.findAll();
        return list.stream().map(EventDTO::new).toList();
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event event = new Event();
        dtoToEntity(dto, event);
        event = eventRepository.save(event);
        return new EventDTO(event);
    }

    private void dtoToEntity(EventDTO dto, Event entity) {
        entity.setData(LocalDate.parse(dto.getData()));
        entity.setTitulo(dto.getTitulo());
        entity.setLocal(dto.getLocal());
        entity.setSite(dto.getSite());
        entity.setHorario(LocalTime.parse(dto.getHorario()));
    }
}
