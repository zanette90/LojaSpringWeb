package br.com.alan.lojaSpringWeb.model;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import jakarta.persistence.*;

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
        if(dtoProduto.produtoNome() != null){
            this.produtoNome = dtoProduto.produtoNome();
        }
        if(dtoProduto.preco() != null) {
            this.preco = dtoProduto.preco();
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

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


}