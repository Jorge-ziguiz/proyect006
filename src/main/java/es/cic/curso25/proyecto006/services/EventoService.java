package es.cic.curso25.proyecto006.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.curso25.proyecto006.pojos.Evento;
import es.cic.curso25.proyecto006.repositories.EventoRepository;

@Service
public class EventoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoService.class);

    @Autowired
    private EventoRepository eventoRepository;

    public Evento createEvent(Evento evento) {

        return eventoRepository.save(evento);
    }

    public Evento getEvent(Long id) {
        LOGGER.info("obteniedo registro: " + id);
        Optional<Evento> evento = eventoRepository.findById(Long.valueOf(id));
        return evento.orElse(null);
    }

    public List<Evento> getAllEvents() {
        List<Evento> events = eventoRepository.findAll();
        return events;
    }

    public void deleteEvent(Long id) {
        eventoRepository.deleteById(Long.valueOf(id));
    }

    public void updateEvent(Evento evento) {
        eventoRepository.save(evento);
    }

}
