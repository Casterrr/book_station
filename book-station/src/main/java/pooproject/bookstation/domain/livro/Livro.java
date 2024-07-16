package pooproject.bookstation.domain.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.item.Item;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LIVRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_LIVRO", nullable = false)
    private String idLivro;

    @OneToOne
    @JoinColumn(name = "ID_ITEM")
    private Item item;

    @Column(name = "NUM_ISBN", nullable = false, length = 20)
    private String numISBN;

    @Column(name = "SINOPSE", length = 4000)
    private String sinopse;

    @Column(name = "IDIOMA", nullable = false, length = 50)
    private String idioma;

    //@Column(name = "DTH_CADASTRO_LIVRO", nullable = false)
    //private LocalDateTime dataCadastroLivro;
}