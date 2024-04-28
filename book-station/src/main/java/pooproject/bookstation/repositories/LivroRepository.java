package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
