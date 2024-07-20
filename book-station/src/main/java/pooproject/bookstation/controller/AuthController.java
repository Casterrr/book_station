package pooproject.bookstation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pooproject.bookstation.dto.login.LoginRequest;
import pooproject.bookstation.dto.login.LoginResponse;
import pooproject.bookstation.dto.register.RegisterRequest;
import pooproject.bookstation.security.JwtUtil;
import pooproject.bookstation.repositories.UsuarioRepository;
import pooproject.bookstation.domain.usuario.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = findAndValidateUser(loginRequest.getEmail());
            validatePassword(loginRequest.getPassword(), usuario);
            String jwt = generateJwtToken(usuario);
            return createSuccessResponse(jwt, usuario);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            logUnexpectedError(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro durante o login");
        }
    }

    private Usuario findAndValidateUser(String email) throws AuthenticationException {
        Usuario usuario = usuarioRepository.findByEmailUsuario(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado no banco de dados: " + email);
            throw new AuthenticationException("Usuário não encontrado");
        }
        System.out.println("Usuário encontrado: " + usuario.getEmailUsuario());
        return usuario;
    }

    private void validatePassword(String rawPassword, Usuario usuario) throws AuthenticationException {
        if (!passwordEncoder.matches(rawPassword, usuario.getSenhaUsuario())) {
            System.out.println("Senha incorreta para usuário: " + usuario.getEmailUsuario());
            throw new AuthenticationException("Senha inválida");
        }
        System.out.println("Senha correta para usuário: " + usuario.getEmailUsuario());
    }

    private String generateJwtToken(Usuario usuario) {
        return jwtUtil.generateToken(usuario);
    }

    private ResponseEntity<?> createSuccessResponse(String jwt, Usuario usuario) {
        return ResponseEntity.ok(new LoginResponse(jwt, usuario.getNomeUsuario(), usuario.getEmailUsuario()));
    }

    private void logUnexpectedError(Exception e) {
        System.out.println("Erro inesperado durante o login: " + e.getMessage());
        e.printStackTrace();
    }

    // Custom exception class
    private static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        System.out.println("Tentativa de registro para usuário: " + registerRequest.getNome());

        if (usuarioRepository.existsByEmailUsuario(registerRequest.getEmail())) {
            System.out.println("Email já está em uso: " + registerRequest.getEmail());
            return ResponseEntity.badRequest().body("Email já está em uso");
        }

        Usuario usuario = new Usuario();
        usuario.setEmailUsuario(registerRequest.getEmail());
        usuario.setNomeUsuario(registerRequest.getNome());
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        usuario.setSenhaUsuario(encodedPassword);
        usuario.setDataCadastroUsuario(LocalDateTime.now());

        usuarioRepository.save(usuario);

        System.out.println("Usuário registrado com sucesso: " + usuario.getNomeUsuario());
        return ResponseEntity.ok("Usuário registrado com sucesso");
    }
}