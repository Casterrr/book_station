package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.devolucao.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Integer> {
}
