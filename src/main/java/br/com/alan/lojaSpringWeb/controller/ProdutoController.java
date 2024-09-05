package br.com.alan.lojaSpringWeb.controller;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import br.com.alan.lojaSpringWeb.service.ServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ServiceProduto serviceProduto;

    @GetMapping("listarProdutos")
    public List<DtoProduto> listarProdutos(){
        return serviceProduto.pegaProdutos();
    }
    @PostMapping("cadastrar")
    public void cadastrarProduto(@RequestBody DtoProduto p) {
        serviceProduto.cadastrarProduto(p);
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") long id, @RequestBody DtoProduto p) {
        serviceProduto.atualizarProduto(id, p);
    }

    @DeleteMapping("{id}")
    public void deletaProduto(@PathVariable("id") long id) {
        serviceProduto.deleteProduto(id);
    }

}
