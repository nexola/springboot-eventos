package com.univercode.eventos.services;

import com.univercode.eventos.dtos.EventDTO;
import com.univercode.eventos.entities.Event;
import com.univercode.eventos.exceptions.ResourceNotFoundException;
import com.univercode.eventos.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Transactional
    public void insert(Event event) {
        event = eventRepository.save(event);
        new EventDTO(event);
    }

    @Transactional(readOnly = true)
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }
}
