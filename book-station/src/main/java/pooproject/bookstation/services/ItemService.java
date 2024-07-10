package pooproject.bookstation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pooproject.bookstation.domain.item.Item;
import pooproject.bookstation.dto.item.ItemIdDTO;
import pooproject.bookstation.dto.item.ItemRequestDTO;
import pooproject.bookstation.dto.item.ItemResponseDTO;
import pooproject.bookstation.repositories.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponseDTO getItemDetail(String itemId){
        Item item = this.itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with ID: "+itemId));
        return new ItemResponseDTO(item);
    }

    public ItemIdDTO createItem(ItemRequestDTO itemDTO){
        Item newItem = new Item();
        newItem.setEditora(itemDTO.idEditora());
        //newItem.setIdItem(itemDTO.idItem());
        System.out.println(itemDTO.idEditora());
        newItem.setAutor(itemDTO.idAutor());
        System.out.println((itemDTO.idAutor()));
        newItem.setGenero(itemDTO.idGenero());
        System.out.println(itemDTO.idGenero());
        newItem.setTitulo(itemDTO.titulo());
        System.out.println(itemDTO.titulo());
        newItem.setAnoPublicacao(itemDTO.anoPublicacao());
        System.out.println(itemDTO.anoPublicacao());
        newItem.setIndTipo(itemDTO.indTipo());
        System.out.println(itemDTO.indTipo());
        newItem.setQuantidadeDisponivel(itemDTO.qtdDisponivel());
        System.out.println(itemDTO.qtdDisponivel());
        newItem.setNumPaginas(itemDTO.numPaginas());
        System.out.println(itemDTO.numPaginas());
        newItem.setDisponivel(itemDTO.indDisponivel());
        System.out.println(itemDTO.indDisponivel());
        System.out.println(newItem.getIdItem());
        System.out.println(newItem);
        this.itemRepository.save(newItem);
        return new ItemIdDTO(newItem.getIdItem());
    }

    public void deleteItem(String idItem){
        Item item = this.itemRepository.findById(idItem).orElseThrow(() -> new RuntimeException("Item not found with ID: "+idItem));;
        this.itemRepository.delete(item);
    }
}
