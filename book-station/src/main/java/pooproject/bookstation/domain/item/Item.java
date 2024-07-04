package pooproject.bookstation.domain.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.autor.Autor;
import pooproject.bookstation.domain.editora.Editora;
import pooproject.bookstation.domain.genero.Genero;

@Entity
@Table(name = "TB_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM", nullable = false)
    private Integer idItem;

    @Column(name = "TITULO", nullable = false, length = 255)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORA")
    private Editora editora;

    @Column(name = "ANO_PUBLICACAO")
    private Integer anoPublicacao;
    
    @Column(name = "IND_TIPO", nullable = false, length = 1)
    private String indTipo;

    @Column(name = "QTD_DISPONIVEL", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "IND_DISPONIVEL", length = 1)
    private String disponivel;
}