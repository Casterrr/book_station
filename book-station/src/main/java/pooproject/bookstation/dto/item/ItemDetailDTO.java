package pooproject.bookstation.dto.item;

import pooproject.bookstation.domain.autor.Autor;
import pooproject.bookstation.domain.editora.Editora;
import pooproject.bookstation.domain.genero.Genero;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record ItemDetailDTO(
    Integer idItem,
    Editora idEditora,
    Autor idAutor,
    Genero idGenero,
    String titulo,
    Integer anoPublicacao,
    String indTipo,
    Integer qtdDisponivel,
    Integer numPagina,
    String indDisponivel
) {
}
