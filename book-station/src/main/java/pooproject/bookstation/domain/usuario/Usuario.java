package pooproject.bookstation.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_USUARIO", nullable = false, columnDefinition = "VARCHAR(36)")
    private String idUsuario;

    @Column(name = "NOME_USUARIO", nullable = false, length = 100)
    private String nomeUsuario;

    @Column(name = "EMAIL", nullable = false, length = 40)
    private String emailUsuario;

    @Column(name = "SENHA_USUARIO", nullable = false, length = 255)
    private String senhaUsuario;

    @Column(name = "DTH_CADASTRO_USUARIO", nullable = false)
    private LocalDateTime dataCadastroUsuario;

    public void setDataCadastroUsuario(LocalDateTime dataCadastroUsuario) {
        this.dataCadastroUsuario = dataCadastroUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senhaUsuario;
    }

    @Override
    public String getUsername() {
        return this.emailUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}