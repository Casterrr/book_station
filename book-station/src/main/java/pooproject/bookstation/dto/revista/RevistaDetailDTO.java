package pooproject.bookstation.dto.revista;

public record RevistaDetailDTO(
        String issn,
        String frequenciaPublicacao,
        Integer numPublicacao,
        Integer numEdicao,
        Integer volume,
        String descricao
) {
}
