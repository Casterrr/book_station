package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.multa.Multa;

public interface MultaRepository extends JpaRepository<Multa, Integer> {
}
