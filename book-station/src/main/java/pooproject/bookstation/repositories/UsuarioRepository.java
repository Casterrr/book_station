package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByNomeUsuario(String nomeUsuario);

    Usuario findByEmailUsuario(String emailUsuario);

    boolean existsByEmailUsuario(String emailUsuario);
}
