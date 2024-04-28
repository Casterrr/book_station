package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.genero.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
