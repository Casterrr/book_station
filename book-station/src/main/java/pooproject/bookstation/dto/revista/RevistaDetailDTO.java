package pooproject.bookstation.dto.revista;

import pooproject.bookstation.domain.item.Item;

public record RevistaDetailDTO(
        Item item,
        String issn,
        String frequenciaPublicacao,
        Integer numEdicao,
        Integer volume,
        String descricao
) {
}
