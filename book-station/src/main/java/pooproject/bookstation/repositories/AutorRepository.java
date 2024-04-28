package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
