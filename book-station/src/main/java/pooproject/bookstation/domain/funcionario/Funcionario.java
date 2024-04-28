package pooproject.bookstation.domain.funcionario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.usuario.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_FUNCIONARIO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "DSC_CARGO", nullable = false, length = 50)
    private String cargo;

    @Column(name = "VLR_SALARIO", nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(name = "NUM_CTPS", nullable = false, length = 11)
    private String numeroCTPS;

    @Column(name = "DAT_ADMISSAO", nullable = false)
    private LocalDateTime dataAdmissao;

    // Getters and setters
}
