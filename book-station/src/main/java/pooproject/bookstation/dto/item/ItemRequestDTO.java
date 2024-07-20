package pooproject.bookstation.dto.item;

import pooproject.bookstation.domain.autor.Autor;
import pooproject.bookstation.domain.editora.Editora;
import pooproject.bookstation.domain.genero.Genero;


public record ItemRequestDTO(
        //Integer idItem,
        //Editora idEditora,
        //Autor idAutor,
        //Genero idGenero,
        String titulo,
        Integer anoPublicacao,
        String indTipo,
        Integer qtdDisponivel,
        Integer numPaginas,
        String indDisponivel
) {
}
