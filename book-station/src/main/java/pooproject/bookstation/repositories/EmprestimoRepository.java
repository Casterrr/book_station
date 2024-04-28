package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
