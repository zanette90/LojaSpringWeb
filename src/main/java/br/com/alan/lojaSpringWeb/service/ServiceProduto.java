package br.com.alan.lojaSpringWeb.service;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import br.com.alan.lojaSpringWeb.model.Produto;
import br.com.alan.lojaSpringWeb.repository.RepositoryProduto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

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
        Optional<Produto> buscaProduto = repositoryProduto.findById(id);
        if (buscaProduto.isPresent()) {
            buscaProduto.get().atualizarInformacoes(dadosAtualizar);
            repositoryProduto.save(buscaProduto.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
    }

    public ResponseEntity<Void> deleteProduto(@PathVariable long id) {
        Optional<Produto> buscaProduto = repositoryProduto.findById(id);
        if (repositoryProduto.existsById(id)) {
            repositoryProduto.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
