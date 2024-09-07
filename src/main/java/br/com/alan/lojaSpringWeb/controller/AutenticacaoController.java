package br.com.alan.lojaSpringWeb.controller;

import br.com.alan.lojaSpringWeb.config.TokenService;
import br.com.alan.lojaSpringWeb.dto.AutenticacaoDto;
import br.com.alan.lojaSpringWeb.dto.LoginResponseDto;
import br.com.alan.lojaSpringWeb.dto.RegistrarDTO;
import br.com.alan.lojaSpringWeb.repository.RepositoryUsuario;
import br.com.alan.lojaSpringWeb.user.UserRole;
import br.com.alan.lojaSpringWeb.user.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody  @Valid AutenticacaoDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.geraToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody RegistrarDTO data) {
        if(this.repositoryUsuario.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novoUsuario = new Usuario(data.login(), encryptedPassword, data.nome(), UserRole.ADMIN);
        this.repositoryUsuario.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}
