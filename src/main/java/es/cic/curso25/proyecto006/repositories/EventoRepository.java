package es.cic.curso25.proyecto006.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import es.cic.curso25.proyecto006.pojos.Evento;

@Repository
public class EventoRepository {

    private Map<Long, Evento> eventos = new HashMap<>();

    public Long create(Evento evento) {
        long mayor = 0;

        Set<Long> ids = eventos.keySet();

        Iterator<Long> iteratorid = ids.iterator();

        while (iteratorid.hasNext()) {
            Long next = iteratorid.next();
            if (next.longValue() > mayor) {
                mayor = next;
            }
        }
        return ++mayor;
    }

    // public Long update(){
    


    // }

    private long getSiguienteConStreams() {

        long mayor = eventos
                .keySet()
                .stream()
                .max(
                        (primero, segundo) -> (int) (segundo - primero))
                .get();

        return mayor + 1;
    }
}
