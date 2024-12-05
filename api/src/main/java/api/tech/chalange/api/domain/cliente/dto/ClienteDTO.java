package api.tech.chalange.api.domain.cliente.dto;

import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.endereco.entity.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record ClienteDTO(

        @NotNull
        TipoPessoa tipoPessoa,

        @NotBlank
        @Size(min = 11, max = 14)
        String paper,

        @NotBlank
        String name,

        @NotBlank
        @Email
        String primaryEmail,

        @NotBlank
        @Email
        String secundaryEmail,

        @NotNull
        List<Endereco> endereco
) {
}
