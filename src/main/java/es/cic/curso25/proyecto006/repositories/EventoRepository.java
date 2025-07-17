package es.cic.curso25.proyecto006.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic.curso25.proyecto006.pojos.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
