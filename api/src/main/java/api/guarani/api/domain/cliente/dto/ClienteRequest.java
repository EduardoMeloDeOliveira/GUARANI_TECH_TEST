package api.guarani.api.domain.cliente.dto;

import api.guarani.api.domain.endereco.dto.EnderecoRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ClienteRequest(
        @NotBlank(message = "Razão social é obrigatória")
        String razaoSocial,

        @NotBlank(message = "Tipo de pessoa é obrigatório")
        @Pattern(regexp = "F|J", message = "Tipo de pessoa deve ser 'F' para física ou 'J' para jurídica")
        String tipoPessoa,

        @NotBlank(message = "CPF/CNPJ é obrigatório")
        @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF deve ter 11 dígitos e CNPJ 14 dígitos")
        String cpfCnpj,

        @Size(min = 1, message = "A pessoa deve ter pelo menos um endereço")
        List<EnderecoRequest> enderecos,

        @NotBlank(message = "E-mail principal é obrigatório")
        @Email(message = "E-mail principal deve ser válido")
        String emailPrincipal,

        @Email(message = "E-mail secundário deve ser válido")
        String emailSecundario,

        String nomeFantasia
) {}

