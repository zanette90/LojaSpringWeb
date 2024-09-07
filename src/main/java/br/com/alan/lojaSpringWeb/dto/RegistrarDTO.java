package br.com.alan.lojaSpringWeb.dto;

import br.com.alan.lojaSpringWeb.user.UserRole;

public record RegistrarDTO(
        String login,
        String nome,
        String senha,
        UserRole role
) {
}
