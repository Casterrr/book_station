package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.funcionario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
