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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REVISTA", nullable = false)
    private Integer idRevista;

    @OneToOne
    @JoinColumn(name = "ID_ITEM", nullable = false)
    private Item item;

    @Column(name = "ISSN", nullable = false, length = 20)
    private String issn;

    @Column(name = "FREQUENCIA_PUBLICACAO", length = 50)
    private String frequenciaPublicacao;
}