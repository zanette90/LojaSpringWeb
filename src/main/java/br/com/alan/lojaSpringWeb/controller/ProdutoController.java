package br.com.alan.lojaSpringWeb.controller;

import br.com.alan.lojaSpringWeb.dto.DtoProduto;
import br.com.alan.lojaSpringWeb.service.ServiceProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ServiceProduto serviceProduto;

    @GetMapping("listar")
    public List<DtoProduto> listarProdutos(){
        return serviceProduto.pegaProdutos();
    }
    @PostMapping("cadastrar")
    public void cadastrarProduto(@RequestBody @Valid DtoProduto p) {
        serviceProduto.cadastrarProduto(p);
    }

    @PatchMapping("{id}")
    public void atualizarProduto(@PathVariable("id") long id, @RequestBody @Valid DtoProduto p) {
        serviceProduto.atualizarProduto(id, p);
    }

    @DeleteMapping("{id}")
    public void deletaProduto(@PathVariable("id") long id) {
        serviceProduto.deleteProduto(id);
    }

}
