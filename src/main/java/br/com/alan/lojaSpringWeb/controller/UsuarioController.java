package br.com.alan.lojaSpringWeb.controller;

import br.com.alan.lojaSpringWeb.dto.DtoUsuario;
import br.com.alan.lojaSpringWeb.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("listar")
    public List<DtoUsuario> listarUsuario() {
        return serviceUsuario.buscarUsuarios();
    }

    @PutMapping("cadastrar")
    public void cadastrarUsuario() {
    }

}
