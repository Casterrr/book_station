package pooproject.bookstation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pooproject.bookstation.domain.item.Item;
import pooproject.bookstation.domain.livro.Livro;
import pooproject.bookstation.domain.revista.Revista;
import pooproject.bookstation.dto.revista.RequestRevistaDTO;
import pooproject.bookstation.dto.revista.RevistaIdDTO;
import pooproject.bookstation.repositories.ItemRepository;
import pooproject.bookstation.repositories.RevistaRepository;

@Service
@RequiredArgsConstructor
public class RevistaService {

    private final RevistaRepository revistaRepository;
    private final ItemRepository itemRepository;

    public RevistaIdDTO createRevista(RequestRevistaDTO revistaDTO){
        Item newItem = new Item();
        Livro newLivro= new Livro();
        //newItem.setEditora(revistaDTO.item().idEditora());
        //newItem.setAutor(revistaDTO.item().idAutor());
        //newItem.setGenero(revistaDTO.item().idGenero());
        newItem.setTitulo(revistaDTO.item().titulo());
        newItem.setAnoPublicacao(revistaDTO.item().anoPublicacao());
        newItem.setIndTipo(revistaDTO.item().indTipo());
        newItem.setQuantidadeDisponivel(revistaDTO.item().qtdDisponivel());
        newItem.setNumPaginas(revistaDTO.item().numPaginas());
        newItem.setDisponivel(revistaDTO.item().indDisponivel());
        this.itemRepository.save(newItem);

        Revista revista = new Revista();
        revista.setItem(newItem);
        revista.setIssn(revistaDTO.issn());
        revista.setFrequenciaPublicacao(revistaDTO.frequenciaPublicacao());
        revista.setNumEdicao(revistaDTO.numEdicao());
        revista.setVolume(revistaDTO.volume());
        revista.setDescricao(revistaDTO.descricao());
        this.revistaRepository.save(revista);

        return new RevistaIdDTO(revista.getIdRevista());
    }

    public RevistaIdDTO updateRevista(RequestRevistaDTO revistaDTO, String idRevista){
        Revista revista = getRevista(idRevista);
        revista.setIssn(revistaDTO.issn());
        revista.setFrequenciaPublicacao(revistaDTO.frequenciaPublicacao());
        revista.setVolume(revistaDTO.volume());
        revista.setNumEdicao(revistaDTO.numEdicao());
        revista.setDescricao(revistaDTO.descricao());
        this.revistaRepository.save(revista);
        return new RevistaIdDTO(revista.getIdRevista());
    }

    public Revista getRevista(String idRevista){
        Revista revista = revistaRepository.findById(idRevista).orElseThrow(() -> new RuntimeException("Revista not found with ID: "+idRevista));;
        return revista;
    }
}
