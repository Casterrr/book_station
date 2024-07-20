package pooproject.bookstation.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    protected final ItemRepository itemRepository;

    public ItemResponseDTO getItemDetail(String itemId){
        Item item = this.itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with ID: "+itemId));
        return new ItemResponseDTO(item);
    }

    public ItemIdDTO createItem(ItemRequestDTO itemDTO){
        Item newItem = new Item();
        //newItem.setEditora(itemDTO.idEditora());
        //newItem.setAutor(itemDTO.idAutor());
        //newItem.setGenero(itemDTO.idGenero());
        newItem.setTitulo(itemDTO.titulo());
        newItem.setAnoPublicacao(itemDTO.anoPublicacao());
        newItem.setIndTipo(itemDTO.indTipo());
        newItem.setQuantidadeDisponivel(itemDTO.qtdDisponivel());
        newItem.setNumPaginas(itemDTO.numPaginas());
        newItem.setDisponivel(itemDTO.indDisponivel());
        this.itemRepository.save(newItem);
        return new ItemIdDTO(newItem.getIdItem());
    }

    public int deleteItem(String idItem){
        try {
            Item item = this.itemRepository.findById(idItem).orElseThrow(() -> new RuntimeException("Item not found with ID: "+idItem));;
            this.itemRepository.delete(item);
            return 200;
        }catch (RuntimeException e){
            return 404;
        } catch (Exception e){
            return 500;
        }

    }
}
