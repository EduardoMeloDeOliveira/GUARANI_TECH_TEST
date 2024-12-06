package api.tech.chalange.api.domain.produto.repository;

import api.tech.chalange.api.domain.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> , JpaSpecificationExecutor<Produto> {

List<Produto>findByCodigoEmpresa(String codigoEmpresa);
}
