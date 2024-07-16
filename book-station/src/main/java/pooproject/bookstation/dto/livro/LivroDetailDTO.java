package pooproject.bookstation.dto.livro;

import pooproject.bookstation.domain.item.Item;

public record LivroDetailDTO(
        Item item,
        String numISBN,
        String sinopse,
        String idioma
) {
}
