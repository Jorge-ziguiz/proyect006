package es.cic.curso25.proyecto006;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proyecto006.pojos.Evento;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class EventoControllerTests {

    @Autowired
    private MockMvc Mvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCreateEvent() throws Exception {

        Evento event = new Evento();
        event.setDate("19/05/2014");
        event.setDescription("una descripcion");
        event.setTitle("un evento");
        event.setLocation("un lugar");

        String eventoJson = objectMapper.writeValueAsString(event);

        Mvc.perform(post("/evento")
                .contentType("application/json")
                .content(eventoJson))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String respeusta = result.getResponse().getContentAsString();
                    Evento newRegister = objectMapper.readValue(respeusta, Evento.class);
                    assertTrue(newRegister.getId() > 0, "valor del ID dene ser mayor a 0");
                })
                .andDo(print())
                .andReturn();
    }

    @Test
    void testDeleteEvent() {

    }

    @Test
    void testGetAllEvents() throws Exception {
        //TODO completar test de getAll
        // Mvc.perform(get("/event")).andDo(print())
        //         .andExpect(status().isOk()).andReturn();

    }

    @Test
    void testGetEvente() {

    }

    @Test
    void testUpdateEvent() {

    }
}
