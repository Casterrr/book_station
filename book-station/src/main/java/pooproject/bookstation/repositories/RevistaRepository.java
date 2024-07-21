package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.revista.Revista;

import java.util.Optional;

public interface RevistaRepository extends JpaRepository<Revista, String> {
    Optional<Revista> findByItemIdItem(String item);
}
