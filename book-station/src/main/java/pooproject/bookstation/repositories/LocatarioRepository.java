package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.locatario.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer>  {
}
