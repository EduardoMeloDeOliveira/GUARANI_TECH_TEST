package api.tech.chalange.api.domain.cliente.dto;

import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.endereco.entity.Endereco;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientePessoaJuridicaDTO implements ClienteBaseDTO {
    private String clienteId;
    private String nomeFantasia;
    private String primeiroEmail;
    private String segundoEmail;
    private List<Endereco> enderecoList;
    private TipoPessoa tipoPessoa;
}
