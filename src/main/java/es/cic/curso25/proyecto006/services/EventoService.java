package es.cic.curso25.proyecto006.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.curso25.proyecto006.pojos.Evento;
import es.cic.curso25.proyecto006.repositories.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public long createEvent(Evento evento) {

        return eventoRepository.save(evento).getId();
    }

    public Evento getEvent(Long id) {
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
