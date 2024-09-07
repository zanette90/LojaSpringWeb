package br.com.alan.lojaSpringWeb.model;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.Objects;

@Entity
@Table(name="Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idproduto;
    private String produtoNome;
    private double preco;
    private long estoque;

    public Produto() {

    }
    public Produto(long idproduto, String produtoNome, double preco) {
        this.idproduto = idproduto;
        this.produtoNome = produtoNome;
        this.preco = preco;
    }

    public  void atualizarInformacoes(DtoProduto dtoProduto) {
        this.produtoNome = Objects.requireNonNullElse(dtoProduto.produtoNome(), this.produtoNome);
        if (dtoProduto.preco() != 0) {
            setPreco(dtoProduto.preco());
        }
        if (dtoProduto.estoque() != 0) {
            setEstoque(dtoProduto.estoque());
        }
    }

    public long getIdProduto() {
        return idproduto;
    }

    public void setIdProduto(long id) {
        this.idproduto = id;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public long getEstoque() {
        return estoque;
    }

    public void setEstoque(long estoque) {
        this.estoque = estoque;
    }

}
