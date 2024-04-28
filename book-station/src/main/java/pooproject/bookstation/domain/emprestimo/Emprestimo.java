package pooproject.bookstation.domain.emprestimo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.livro.Livro;
import pooproject.bookstation.domain.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_EMPRESTIMO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESTIMO", nullable = false)
    private Integer idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "ID_LIVRO")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "DTH_EMPRESTIMO", nullable = false)
    private LocalDateTime dataEmprestimo;

    @Column(name = "DTH_DEVOLUCAO_PREVISTA", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    // Getters and setters
}
