package api.tech.chalange.api.domain.produto.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoResDTO(

        String descricao,
        String codigo,
        int estoque,
        BigDecimal precoMinimo
) {
}
