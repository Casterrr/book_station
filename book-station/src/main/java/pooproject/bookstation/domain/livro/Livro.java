package pooproject.bookstation.domain.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.autor.Autor;
import pooproject.bookstation.domain.editora.Editora;
import pooproject.bookstation.domain.genero.Genero;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_LIVRO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIVRO", nullable = false)
    private Integer idLivro;

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

    @Column(name = "NUM_ISBN", nullable = false, length = 20)
    private String numISBN;

    @Column(name = "DAT_PUBLICACAO_LIVRO", nullable = false)
    private LocalDate dataPublicacaoLivro;

    @Column(name = "SINOPSE", length = 4000)
    private String sinopse;

    @Column(name = "NUM_PAGINAS", nullable = false)
    private Integer numPaginas;

    @Column(name = "IDIOMA", nullable = false, length = 50)
    private String idioma;

    @Column(name = "QTD_DISPONIVEL", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "IND_DISPONIVEL", length = 1)
    private String disponivel;

    @Column(name = "DTH_CADASTRO_LIVRO", nullable = false)
    private LocalDateTime dataCadastroLivro;

    // Getters and setters
}
