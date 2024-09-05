package br.com.alan.lojaSpringWeb.service;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import br.com.alan.lojaSpringWeb.model.Produto;
import br.com.alan.lojaSpringWeb.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repositoryProduto;

    public List<DtoProduto> pegaProdutos() {
        return repositoryProduto.findAll().stream().
                map(p -> new DtoProduto(p.getIdProduto(),p.getProdutoNome(),p.getPreco(),p.getEstoque()))
                .collect(Collectors.toList());
    }

    public void cadastrarProduto(DtoProduto dadosCadastro){
        Produto produto = new Produto(dadosCadastro.idproduto(), dadosCadastro.produtoNome(), dadosCadastro.preco());
        repositoryProduto.save(produto);
    }

    public void atualizarProduto(long id, DtoProduto dadosAtualizar) {
        var buscaProduto = repositoryProduto.findById(id);
        if (buscaProduto.isPresent()) {
            buscaProduto.get().atualizarInformacoes(dadosAtualizar);
            repositoryProduto.save(buscaProduto.get());
        }
    }

    public void deleteProduto(@PathVariable long id) {
        var buscaProduto = repositoryProduto.findById(id);
        if (buscaProduto.isPresent()) {
            repositoryProduto.deleteById(id);
        }
    }
    
}
