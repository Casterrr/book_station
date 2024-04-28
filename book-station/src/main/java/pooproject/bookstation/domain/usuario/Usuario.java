package pooproject.bookstation.domain.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USUARIO")
// Cria os getters e setters automaticamente
@Getter
@Setter
// Cria um construtor com todos os parâmetros e um sem parâmetros
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "NOME_USUARIO", nullable = false, length = 100)
    private String nomeUsuario;

    @Column(name = "ENDERECO_USUARIO", nullable = false, length = 255)
    private String enderecoUsuario;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpfUsuario;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String emailUsuario;

    @Column(name = "TELEFONE_USUARIO", nullable = false, length = 20)
    private String telefoneUsuario;

    @Column(name = "DTH_CADASTRO_USUARIO", nullable = false)
    private LocalDateTime dataCadastroUsuario;
}
