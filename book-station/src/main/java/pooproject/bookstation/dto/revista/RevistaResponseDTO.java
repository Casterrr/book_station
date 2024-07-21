package pooproject.bookstation.dto.revista;

import pooproject.bookstation.domain.livro.Livro;
import pooproject.bookstation.domain.revista.Revista;
import pooproject.bookstation.dto.livro.LivroDetailDTO;

public class RevistaResponseDTO {
    RevistaDetailDTO revistaDetailDTO;

    public RevistaResponseDTO(Revista revista){
        this.revistaDetailDTO = new RevistaDetailDTO(
                revista.getItem(),
                revista.getIssn(),
                revista.getFrequenciaPublicacao(),
                revista.getNumEdicao(),
                revista.getVolume(),
                revista.getDescricao()
        );
    }
}
