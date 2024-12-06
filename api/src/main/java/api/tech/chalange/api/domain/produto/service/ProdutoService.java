package api.tech.chalange.api.domain.produto.service;

import api.tech.chalange.api.domain.produto.dto.ProdutoResDTO;
import api.tech.chalange.api.domain.produto.entity.Produto;
import api.tech.chalange.api.domain.produto.repository.ProdutoRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoResDTO> buscarProdutos(String descricao, String codigo, Double estoqueMinimo, Double precoMaximo) {
        Specification<Produto> spec = Specification.where((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (descricao != null && !descricao.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%"));
            }
            if (codigo != null && !codigo.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codigo"), codigo));
            }
            if (estoqueMinimo != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("estoque"), estoqueMinimo));
            }
            if (precoMaximo != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("precoMaximo"), precoMaximo));
            }

            return predicate;
        });

        return produtoRepository.findAll(spec).stream().map(produto -> ProdutoResDTO.builder()
                .descricao(produto.getDescricao())
                .codigo(produto.getCodigo())
                .estoque(produto.getSituacaoEstoque())
                .precoMinimo(produto.getPrecoMinimo())
                .build()
        ).collect(Collectors.toList());
    }
}

