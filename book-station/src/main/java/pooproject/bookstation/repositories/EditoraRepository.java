package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.editora.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {
}
