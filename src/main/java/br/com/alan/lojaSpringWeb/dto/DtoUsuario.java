package br.com.alan.lojaSpringWeb.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DtoUsuario(String login,
                         String nome) {
}
