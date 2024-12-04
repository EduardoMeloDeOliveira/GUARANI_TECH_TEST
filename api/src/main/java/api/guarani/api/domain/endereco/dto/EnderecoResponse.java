package api.guarani.api.domain.endereco.dto;

import lombok.Builder;

@Builder
public record EnderecoResponse(
        String logradouro,
        String numero,
        String complemento,
        String codigoMunicipio,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}