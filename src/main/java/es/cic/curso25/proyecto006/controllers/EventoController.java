package es.cic.curso25.proyecto006.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyecto006.pojos.Evento;
import es.cic.curso25.proyecto006.services.EventoService;

@RestController
@RequestMapping("event")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping()
    public void createEvent(@RequestBody Evento evento) {
        eventoService.createEvent(evento);

    }

    @GetMapping("/{id}")
    public Evento getEvente(@PathVariable long id) {
        return eventoService.getEvent(id);

    }

    @GetMapping()
    public List<Evento> getAllEvents() {
        return eventoService.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventoService.deleteEvent(id);

    }

    @PutMapping()
    public void updateEvent(@RequestBody Evento evento) {
        eventoService.updateEvent(evento);
    }

}
