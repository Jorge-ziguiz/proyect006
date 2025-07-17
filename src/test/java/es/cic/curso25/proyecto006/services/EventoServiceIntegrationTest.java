package es.cic.curso25.proyecto006.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.cic.curso25.proyecto006.pojos.Evento;

@SpringBootTest
public class EventoServiceIntegrationTest {

    @Autowired
    private EventoService eventoService;

    @Test
    void testCreateEvent() {
        Evento evento = new Evento("17/07/2025", "Santander", "Formacion CIC", "una formacion de java en CIC");
        
        long ResultoID = eventoService.createEvent(evento);
        assertTrue(ResultoID > 0, String.format("el id no  debe ser no positivo %d", ResultoID));
    }

    @Test
    void testDeleteEvent() {
        Evento evento = new Evento("17/07/2025", "Santander", "Formacion CIC", "una formacion de java en CIC");
        long ResultoID = eventoService.createEvent(evento);

        Evento EventoRetorno = eventoService.getEvent(Long.valueOf(ResultoID));

        assertEquals("Santander", EventoRetorno.getLocation());

    }

    @Test
    void testGetAllEvents() {

    }

    @Test
    void testGetEvent() {

    }

    @Test
    void testUpdateEvent() {

    }
}
