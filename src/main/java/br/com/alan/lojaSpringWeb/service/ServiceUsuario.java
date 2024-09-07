package br.com.alan.lojaSpringWeb.service;

import br.com.alan.lojaSpringWeb.dto.DtoUsuario;
import br.com.alan.lojaSpringWeb.repository.RepositoryUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceUsuario {

    private RepositoryUsuario repositoryUsuario;

    public List<DtoUsuario> buscarUsuarios() {
        return repositoryUsuario.findAll().stream()
                .map(u -> new DtoUsuario(u.getLogin(),u.getNome()))
                .collect(Collectors.toList());
    }

}
