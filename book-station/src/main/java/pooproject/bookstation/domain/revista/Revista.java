package pooproject.bookstation.domain.revista;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.item.Item;

@Entity
@Table(name = "TB_REVISTA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_REVISTA", nullable = false)
    private String idRevista;

    @OneToOne
    @JoinColumn(name = "ID_ITEM")
    private Item item;

    @Column(name = "ISSN", nullable = false, length = 20)
    private String issn;

    @Column(name = "FREQUENCIA_PUBLICACAO", nullable = false, length = 50)
    private String frequenciaPublicacao;

    @Column(name = "NUM_EDICAO", nullable = false)
    private Integer numEdicao;

    @Column(name = "VOLUME", nullable = false)
    private Integer volume;

    @Column(name = "DESCRICAO", length = 200)
    private String descricao;
}