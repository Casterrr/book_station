package pooproject.bookstation.domain.reserva;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pooproject.bookstation.domain.livro.Livro;
import pooproject.bookstation.domain.usuario.Usuario;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RESERVA")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA", nullable = false)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_LIVRO")
    private Livro livro;

    @Column(name = "IND_ATENDIDA", nullable = false, length = 1)
    private String indAtendida;

    @Column(name = "DTH_RESERVA", nullable = false)
    private LocalDateTime dataReserva;

    // Getters and setters
}
