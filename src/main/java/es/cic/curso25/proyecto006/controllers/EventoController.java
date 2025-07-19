package es.cic.curso25.proyecto006.controllers;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proyecto006.exepciones.InsertIDExepcion;
import es.cic.curso25.proyecto006.pojos.Evento;
import es.cic.curso25.proyecto006.services.EventoService;

@RestController
@RequestMapping(path = "/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    private Logger LOGGER = LoggerFactory.getLogger(Evento.class);

    @PostMapping()
    public Evento createEvent(@RequestBody Evento evento) {

        try {
            if (evento.getId() != null) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            LOGGER.error("no esta permitido insertar IDs manualmente", e);
            throw new InsertIDExepcion("no esta permitido insertar IDs manualmente", e);
        }
        return eventoService.createEvent(evento);

    }

    @GetMapping("/{id}")
    public Evento getEvente(@PathVariable Long id) {

        return eventoService.getEvent(id);

    }

    @GetMapping()
    public List<Evento> getAllEvents() {
        return eventoService.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventoService.deleteEvent(id);

    }

    @PutMapping()
    public void updateEvent(@RequestBody Evento evento) {
        eventoService.updateEvent(evento);
    }

}
