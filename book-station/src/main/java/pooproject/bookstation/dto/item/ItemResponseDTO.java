package pooproject.bookstation.dto.item;

import lombok.Getter;
import pooproject.bookstation.domain.item.Item;

@Getter
public class ItemResponseDTO {
    ItemDetailDTO itemDTO;

    public ItemResponseDTO(Item item){
        this.itemDTO = new ItemDetailDTO(
                item.getIdItem(),
                item.getEditora(),
                item.getAutor(),
                item.getGenero(),
                item.getTitulo(),
                item.getAnoPublicacao(),
                item.getIndTipo(),
                item.getQuantidadeDisponivel(),
                item.getNumPaginas(),
                item.getDisponivel()
        );
    }
}
