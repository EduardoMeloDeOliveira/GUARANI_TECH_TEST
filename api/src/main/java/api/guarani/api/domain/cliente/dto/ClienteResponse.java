package api.guarani.api.domain.cliente.dto;

import api.guarani.api.domain.endereco.dto.EnderecoResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record ClienteResponse(
        Long id,
        String razaoSocial,
        String nomeFantasia,
        String cpfCnpj,
        String emailPrincipal,
        String emailSecundario,
        List<EnderecoResponse> enderecos
) {}
