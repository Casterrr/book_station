package pooproject.bookstation.dto.livro;

import lombok.Getter;
import pooproject.bookstation.domain.item.Item;
import pooproject.bookstation.domain.livro.Livro;

@Getter
public class LivroResponseDTO {
    LivroDetailDTO livroDTO;

    public LivroResponseDTO(Livro livro){
        this.livroDTO = new LivroDetailDTO(
                livro.getItem(),
                livro.getNumISBN(),
                livro.getSinopse(),
                livro.getIdioma()
        );
    }
}
