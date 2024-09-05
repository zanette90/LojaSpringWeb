package br.com.alan.lojaSpringWeb.dto;

import com.fasterxml.jackson.annotation.JsonAlias;


public record DtoProduto(@JsonAlias("id") long idproduto,
                         @JsonAlias("nome") String produtoNome,
                         @JsonAlias("preco") double preco,
                        @JsonAlias("estoque") double estoque) {
}
