package pooproject.bookstation.dto.revista;

import lombok.Getter;
import pooproject.bookstation.domain.revista.Revista;

@Getter
public class RevistaResponseDTO {
    RevistaDetailDTO revistaDetailDTO;

    public RevistaResponseDTO(Revista revista) {
        this.revistaDetailDTO = new RevistaDetailDTO(
                revista.getItem(),
                revista.getIssn(),
                revista.getFrequenciaPublicacao(),
                revista.getNumEdicao(),
                revista.getVolume(),
                revista.getDescricao());
    }
}
