package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.livro.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, String> {
    Optional<Livro> findByItemIdItem(String item);
}
