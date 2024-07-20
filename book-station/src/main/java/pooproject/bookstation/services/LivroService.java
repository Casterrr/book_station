package pooproject.bookstation.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pooproject.bookstation.domain.item.Item;
import pooproject.bookstation.domain.livro.Livro;
import pooproject.bookstation.dto.item.ItemIdDTO;
import pooproject.bookstation.dto.livro.LivroIdDTO;
import pooproject.bookstation.dto.livro.LivroRequestDTO;
import pooproject.bookstation.dto.livro.LivroResponseDTO;
import pooproject.bookstation.repositories.ItemRepository;
import pooproject.bookstation.repositories.LivroRepository;

@Service
@RequiredArgsConstructor
public class LivroService{
    private final LivroRepository livroRepository;
    private final ItemRepository itemRepository;

    public LivroResponseDTO getLivroDetail(String livroId){
        //this.livroRepository.getReferenceById()
        //Livro livro = this.livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro not found with ID: "+livroId));
        Livro livro = this.livroRepository.getReferenceById(livroId);
        return new LivroResponseDTO(livro);
    }

    public LivroIdDTO createLivro(LivroRequestDTO livroDTO){
        Item newItem = new Item();
        Livro newLivro= new Livro();
        //newItem.setEditora(livroDTO.item().idEditora());
        //newItem.setAutor(livroDTO.item().idAutor());
        //newItem.setGenero(livroDTO.item().idGenero());
        newItem.setTitulo(livroDTO.item().titulo());
        newItem.setAnoPublicacao(livroDTO.item().anoPublicacao());
        newItem.setIndTipo(livroDTO.item().indTipo());
        newItem.setQuantidadeDisponivel(livroDTO.item().qtdDisponivel());
        newItem.setNumPaginas(livroDTO.item().numPaginas());
        newItem.setDisponivel(livroDTO.item().indDisponivel());
        this.itemRepository.save(newItem);

        newLivro.setItem(newItem);
        newLivro.setNumISBN(livroDTO.numISBN());
        newLivro.setSinopse(livroDTO.sinopse());
        newLivro.setIdioma(livroDTO.idioma());
        this.livroRepository.save(newLivro);
        //System.out.println("Salvou livro");
        return new LivroIdDTO(newItem.getIdItem(), newLivro.getIdLivro());
    }

    public LivroIdDTO updateLivro(LivroRequestDTO livroDTO, String idLivro){
        Livro livro = getLivro(idLivro);
        livro.setIdioma(livroDTO.idioma());
        livro.setSinopse(livroDTO.sinopse());
        livro.setNumISBN(livroDTO.numISBN());
        this.livroRepository.save(livro);
        return new LivroIdDTO(livro.getItem().getIdItem(), livro.getIdLivro());
    }

    public Livro getLivro(String idLivro){
        Livro livro = this.livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro not found with ID: "+idLivro));
        return livro;
    }
}
