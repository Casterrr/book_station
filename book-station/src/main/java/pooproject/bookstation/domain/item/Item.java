package pooproject.bookstation.domain.item;

import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.autor.Autor;
import pooproject.bookstation.domain.editora.Editora;
import pooproject.bookstation.domain.genero.Genero;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_ITEM", nullable = false)
    private String idItem;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORA")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;

    @Column(name = "TITULO", nullable = false, length = 255)
    private String titulo;

    @Column(name = "ANO_PUBLICACAO")
    private Integer anoPublicacao;

    @Column(name = "IND_TIPO", nullable = false, length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'L'")
    private String indTipo = "L";

    @Column(name = "QTD_DISPONIVEL", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "NUM_PAGINAS", nullable = false)
    private Integer numPaginas;

    @Column(name = "IND_DISPONIVEL", length = 1, columnDefinition = "VARCHAR(1) DEFAULT 'S'")
    private String disponivel = "S";

    @Column(name = "DTH_CADASTRO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataCadastro = LocalDateTime.now();
}