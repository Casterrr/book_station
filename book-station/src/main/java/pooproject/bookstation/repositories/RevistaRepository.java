package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.revista.Revista;

public interface RevistaRepository extends JpaRepository<Revista, String> {
}
