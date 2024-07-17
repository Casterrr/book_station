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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            System.out.println("Tentativa de login para usuário: " + loginRequest.getEmail());

            // Debug: List all users in the database
            List<Usuario> allUsers = usuarioRepository.findAll();
            System.out.println("Total users in database: " + allUsers.size());
            for (Usuario u : allUsers) {
                System.out.println("User: " + u.getNomeUsuario() + ", Email: " + u.getEmailUsuario());
            }

            Usuario usuario = usuarioRepository.findByEmailUsuario(loginRequest.getEmail());

            if (usuario == null) {
                System.out.println("Usuário não encontrado no banco de dados: " + loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
            }

            System.out.println("Usuário encontrado: " + usuario.getEmailUsuario());

            // Verificar a senha
            if (passwordEncoder.matches(loginRequest.getPassword(), usuario.getSenhaUsuario())) {
                System.out.println("Senha correta para usuário: " + loginRequest.getEmail());

                // Gerar token JWT
                String jwt = jwtUtil.generateToken(usuario);

                return ResponseEntity
                        .ok(new LoginResponse(jwt, usuario.getNomeUsuario(), usuario.getEmailUsuario()));
            } else {
                System.out.println("Senha incorreta para usuário: " + loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha inválida");
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado durante o login: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro durante o login");
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