package pooproject.bookstation.dto.revista;

import pooproject.bookstation.dto.item.ItemRequestDTO;

public record RequestRevistaDTO(
        ItemRequestDTO item,
        String issn,
        String frequenciaPublicacao,
        Integer numPublicacao,
        Integer numEdicao,
        Integer volume,
        String descricao
) {
}
