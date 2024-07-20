package pooproject.bookstation.dto.livro;

import pooproject.bookstation.domain.item.Item;
import pooproject.bookstation.dto.item.ItemRequestDTO;

public record LivroRequestDTO(
        ItemRequestDTO item,
        String numISBN,
        String sinopse,
        String idioma
) {
}
