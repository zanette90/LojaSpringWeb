package br.com.alan.lojaSpringWeb.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DtoProduto(@JsonAlias("id") long idproduto,
                         @JsonAlias("nome") @NotBlank(message = "O nome do produto não pode ser vazio") String produtoNome,
                         @JsonAlias("preco") @Min(value = 1, message = "O preço deve ser maior que 0") double preco,
                         @JsonAlias("estoque") long estoque
                         ) {
}
