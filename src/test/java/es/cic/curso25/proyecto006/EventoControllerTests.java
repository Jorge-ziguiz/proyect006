package es.cic.curso25.proyecto006;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
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

    @Test
    public void testCreateEvent() {
    }

    @Test
    void testDeleteEvent() {

    }

    @Test
    void testGetAllEvents() throws Exception {
        Mvc.perform(get("/event")).andDo(print())
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void testGetEvente() {

    }

    @Test
    void testUpdateEvent() {

    }
}
