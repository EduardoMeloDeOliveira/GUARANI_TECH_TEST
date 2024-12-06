package api.tech.chalange.api.domain.cliente.dto;

import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.endereco.entity.Endereco;
import lombok.Builder;

import java.util.List;

@Builder
public record ClientePessoaFisicaDTO (

        String clienteId,
        String razaoSocial,
        String primeiroEmail,
        String segundoEmail,
        List<Endereco> enderecoList,
        TipoPessoa tipoPessoa


) implements ClienteBaseDTO{
}
