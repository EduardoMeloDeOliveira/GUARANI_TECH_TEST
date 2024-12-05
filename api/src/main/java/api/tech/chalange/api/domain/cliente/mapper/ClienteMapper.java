package api.tech.chalange.api.domain.cliente.mapper;

import api.tech.chalange.api.domain.cliente.dto.ClientePessoaFisicaDTO;
import api.tech.chalange.api.domain.cliente.dto.ClientePessoaJuridicaDTO;
import api.tech.chalange.api.domain.cliente.entity.Cliente;

public class ClienteMapper {



    public static ClientePessoaJuridicaDTO toPessoaJuridicaDTO(Cliente cliente) {

        return ClientePessoaJuridicaDTO.builder()
                .clienteId(cliente.getId())
                .tipoPessoa(cliente.getTipoPessoa())
                .nomeFantasia(cliente.getNomeFantasia())
                .enderecoList(cliente.getEnderecos())
                .primeiroEmail(cliente.getEmailPrincipal())
                .segundoEmail(cliente.getEmailSecundario())
                .build();
    }


    public static ClientePessoaFisicaDTO toPessoaFisicaDTO(Cliente cliente) {

        return ClientePessoaFisicaDTO.builder()
                .clienteId(cliente.getId())
                .tipoPessoa(cliente.getTipoPessoa())
                .razaoSocial(cliente.getRazaoSocial())
                .enderecoList(cliente.getEnderecos())
                .primeiroEmail(cliente.getEmailPrincipal())
                .segundoEmail(cliente.getEmailSecundario())
                .build();
    }
}
