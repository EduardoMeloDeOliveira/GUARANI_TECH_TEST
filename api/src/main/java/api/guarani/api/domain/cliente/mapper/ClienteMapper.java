package api.guarani.api.domain.cliente.mapper;


import api.guarani.api.domain.cliente.dto.ClienteRequest;
import api.guarani.api.domain.cliente.dto.ClienteResponse;
import api.guarani.api.domain.cliente.entity.Cliente;
import api.guarani.api.domain.endereco.dto.EnderecoResponse;
import api.guarani.api.domain.endereco.entity.Endereco;

import java.util.stream.Collectors;

public class ClienteMapper {

    public static Cliente mapToEntity(ClienteRequest clienteRequest) {
        validarCliente(clienteRequest);
        return Cliente.builder()
                .razaoSocial(clienteRequest.razaoSocial())
                .tipoPessoa(clienteRequest.tipoPessoa())
                .cpfCnpj(clienteRequest.cpfCnpj())
                .emailPrincipal(clienteRequest.emailPrincipal())
                .emailSecundario(clienteRequest.emailSecundario())
                .nomeFantasia(clienteRequest.nomeFantasia())
                .enderecos(clienteRequest.enderecos().stream()
                        .map(enderecoRequest -> Endereco.builder()
                                .logradouro(enderecoRequest.logradouro())
                                .numero(enderecoRequest.numero())
                                .complemento(enderecoRequest.complemento())
                                .bairro(enderecoRequest.bairro())
                                .codigoMunicipio(enderecoRequest.codigoMunicipio())
                                .cep(enderecoRequest.cep())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static ClienteResponse mapToResponse(Cliente cliente) {
        return ClienteResponse.builder()
                .id(cliente.getId())
                .razaoSocial(cliente.getRazaoSocial())
                .nomeFantasia(cliente.getNomeFantasia())
                .cpfCnpj(cliente.getCpfCnpj())
                .emailPrincipal(cliente.getEmailPrincipal())
                .emailSecundario(cliente.getEmailSecundario())
                .enderecos(cliente.getEnderecos().stream()
                        .map(endereco -> EnderecoResponse.builder()
                                .logradouro(endereco.getLogradouro())
                                .numero(endereco.getNumero())
                                .complemento(endereco.getComplemento())
                                .bairro(endereco.getBairro())
                                .codigoMunicipio(endereco.getCodigoMunicipio())
                                .cep(endereco.getCep())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private static void validarCliente(ClienteRequest clienteRequest) {
        if ("f".equalsIgnoreCase(clienteRequest.tipoPessoa())) {
            validarPessoaFisica(clienteRequest);
        } else if ("j".equalsIgnoreCase(clienteRequest.tipoPessoa())) {
            validarPessoaJuridica(clienteRequest);
        } else {
            throw new IllegalArgumentException("Tipo de pessoa inválido. Deve ser 'FISICA' ou 'JURIDICA'.");
        }
    }

    private static void validarPessoaFisica(ClienteRequest clienteRequest) {
        if (clienteRequest.cpfCnpj() == null || clienteRequest.cpfCnpj().isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório para pessoa física.");
        }
        if (clienteRequest.nomeFantasia() != null && !clienteRequest.nomeFantasia().isEmpty()) {
            throw new IllegalArgumentException("O nome fantasia não deve ser preenchido para pessoa física.");
        }
        if (clienteRequest.enderecos() == null || clienteRequest.enderecos().isEmpty()) {
            throw new IllegalArgumentException("A pessoa física deve ter pelo menos um endereço.");
        }
    }

    private static void validarPessoaJuridica(ClienteRequest clienteRequest) {
        if (clienteRequest.cpfCnpj() == null || clienteRequest.cpfCnpj().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório para pessoa jurídica.");
        }
        if (clienteRequest.nomeFantasia() == null || clienteRequest.nomeFantasia().isEmpty()) {
            throw new IllegalArgumentException("O nome fantasia é obrigatório para pessoa jurídica.");
        }
        if (clienteRequest.enderecos() == null || clienteRequest.enderecos().isEmpty()) {
            throw new IllegalArgumentException("A pessoa jurídica deve ter pelo menos um endereço.");
        }
    }
}
