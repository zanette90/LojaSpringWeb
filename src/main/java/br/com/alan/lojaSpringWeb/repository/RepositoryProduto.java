package br.com.alan.lojaSpringWeb.repository;

import br.com.alan.lojaSpringWeb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface RepositoryProduto extends JpaRepository<Produto, Long> {

}
