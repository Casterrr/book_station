package pooproject.bookstation.domain.devolucao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.emprestimo.Emprestimo;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DEVOLUCAO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Devolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEVOLUCAO", nullable = false)
    private Integer idDevolucao;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESTIMO")
    private Emprestimo emprestimo;

    @Column(name = "DAT_DEVOLUCAO", nullable = false)
    private LocalDateTime dataDevolucao;

    // Getters and setters
}
