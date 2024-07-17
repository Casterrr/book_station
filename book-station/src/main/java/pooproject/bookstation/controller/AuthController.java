package pooproject.bookstation.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        // Log the received password
        System.out.println("Received password: " + registerRequest.getPassword());

        if (usuarioRepository.existsByEmailUsuario(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        if (registerRequest.getPassword() == null || registerRequest.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be empty");
        }

        Usuario usuario = new Usuario();
        usuario.setEmailUsuario(registerRequest.getEmail());
        usuario.setNomeUsuario(registerRequest.getNome());
        // Log the encoded password
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        System.out.println("Encoded password: " + encodedPassword);
        usuario.setSenhaUsuario(encodedPassword);
        usuario.setDataCadastroUsuario(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("User registered successfully");
    }
}