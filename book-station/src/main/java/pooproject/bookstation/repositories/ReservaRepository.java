package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.reserva.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
