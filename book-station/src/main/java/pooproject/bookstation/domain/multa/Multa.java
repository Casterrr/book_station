package pooproject.bookstation.domain.multa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.devolucao.Devolucao;
import pooproject.bookstation.domain.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MULTA")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MULTA", nullable = false)
    private Integer idMulta;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_DEVOLUCAO")
    private Devolucao devolucao;

    @Column(name = "VALOR_MULTA", precision = 10, scale = 2)
    private BigDecimal valorMulta;

    @Column(name = "DTH_APLICACAO", nullable = false)
    private LocalDateTime dataAplicacao;

    // Getters and setters
}
