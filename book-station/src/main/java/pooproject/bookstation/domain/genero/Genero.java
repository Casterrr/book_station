package pooproject.bookstation.domain.genero;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_GENERO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENERO", nullable = false)
    private Integer idGenero;

    @Column(name = "NOME_GENERO", nullable = false, length = 20)
    private String nomeGenero;

    @Column(name = "DTH_CADASTRO_GENERO", nullable = false)
    private LocalDateTime dataCadastroGenero;

    // Getters and setters
}
