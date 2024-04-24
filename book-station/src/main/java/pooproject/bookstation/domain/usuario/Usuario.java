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
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_USUARIO", nullable = false, length = 100)
    private String nome;

    @Column(name = "ENDERECO_USUARIO", nullable = false, length = 255)
    private String endereco;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String email;

    @Column(name = "TELEFONE_USUARIO", nullable = false, length = 20)
    private String telefone;

    @Column(name = "DTH_CADASTRO_USUARIO", nullable = false)
    private LocalDateTime dataCadastro;
}
