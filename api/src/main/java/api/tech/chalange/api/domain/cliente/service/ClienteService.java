package api.tech.chalange.api.domain.cliente.service;

import api.tech.chalange.api.domain.cliente.dto.ClienteBaseDTO;
import api.tech.chalange.api.domain.cliente.dto.ClienteDTO;
import api.tech.chalange.api.domain.cliente.entity.Cliente;
import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.cliente.mapper.ClienteMapper;
import api.tech.chalange.api.domain.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteBaseDTO saveCliente(ClienteDTO clienteDTO) {

        Cliente cliente = factoryCliente(clienteDTO);

        clienteRepository.save(cliente);

        if (cliente.getTipoPessoa().equals(TipoPessoa.JURIDICA)) {
            return ClienteMapper.toPessoaJuridicaDTO(cliente);
        }

        return ClienteMapper.toPessoaFisicaDTO(cliente);

    }



















    private Cliente factoryCliente(ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();

        cliente.setEnderecos(clienteDTO.endereco());
        cliente.setEmailPrincipal(clienteDTO.primaryEmail());
        cliente.setEmailSecundario(clienteDTO.primaryEmail());

        if (clienteDTO.tipoPessoa().equals(TipoPessoa.FISICA)) {
            cliente.setTipoPessoa(TipoPessoa.FISICA);
            cliente.setCpfCnpj(clienteDTO.paper());
            cliente.setRazaoSocial(clienteDTO.name());
        }

        if (clienteDTO.tipoPessoa().equals(TipoPessoa.JURIDICA)) {
            cliente.setTipoPessoa(TipoPessoa.JURIDICA);
            cliente.setCpfCnpj(clienteDTO.paper());
            cliente.setNomeFantasia(clienteDTO.name());
        }

        return cliente;
    }
}
