package br.com.alan.lojaSpringWeb.service;

import br.com.alan.lojaSpringWeb.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoService implements UserDetailsService {
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUsuario.findByLogin(username);
    }
}
