package es.cic.curso25.proyecto006.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.proyecto006.pojos.Evento;
import es.cic.curso25.proyecto006.repositories.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // TODO esta mal porque deberia ser una consulta a la base de datos y no una
    // varible global igual el id
    private List<Evento> eventos;
    private long contador;

    public void createEvent(Evento evento) {
        evento.setId(++contador);
        List<Evento> events = getAllEvents();
        for (Evento e : events) {
            if (evento.equals(e) || evento.getDate().equalsIgnoreCase(e.getDate())) {
                return;
            }
        }
        events.add(evento);
    }

    public Evento getEvent(long id) {
        List<Evento> events = getAllEvents();
        for (Evento evento : events) {
            if (id == evento.getId()) {
                return evento;
            }
        }
        return null;

    }

    public List<Evento> getAllEvents() {
        if (eventos == null) {
            eventos = new ArrayList<Evento>();
        }
        return eventos;
    }

    public void deleteEvent(long id) {
        List<Evento> events = getAllEvents();
        for (Evento evento : events) {
            if (id == evento.getId()) {
                events.remove(evento);
                break;
            }
        }

    }

    public void updateEvent(Evento evento) {
        List<Evento> events = getAllEvents();
        for (Evento e : events) {
            if (e.getId() == evento.getId()) {
                events.remove(evento);
                events.add(evento);
                break;
            }
        }
    }

}
