package api.guarani.api.domain.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoRequest(
        @NotBlank(message = "Logradouro é obrigatório")
        String logradouro,

        @NotBlank(message = "Número é obrigatório")
        String numero,

        String complemento,

        @NotBlank(message = "Bairro é obrigatório")
        String bairro,

        @NotBlank(message = "Código do município é obrigatório")
        String codigoMunicipio,

        @NotBlank(message = "CEP é obrigatório")
        @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
        String cep
) {}
