package br.com.alan.lojaSpringWeb.repository;

import br.com.alan.lojaSpringWeb.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario,String> {
    UserDetails findByLogin(String login);
}
