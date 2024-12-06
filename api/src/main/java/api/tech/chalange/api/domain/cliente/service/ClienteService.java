package api.tech.chalange.api.domain.cliente.service;

import api.tech.chalange.api.domain.cliente.dto.ClienteBaseDTO;
import api.tech.chalange.api.domain.cliente.dto.ClienteDTO;
import api.tech.chalange.api.domain.cliente.entity.Cliente;
import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.cliente.mapper.ClienteMapper;
import api.tech.chalange.api.domain.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteBaseDTO saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = factoryCliente(clienteDTO);
        clienteRepository.save(cliente);

        if (cliente.getTipoPessoa().equals(TipoPessoa.JURIDICA)) {
            return ClienteMapper.toPessoaJuridicaDTO(cliente);
        } else {
            return ClienteMapper.toPessoaFisicaDTO(cliente);
        }
    }

    public ClienteBaseDTO updateCliente(String id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = factoryCliente(clienteDTO);
            cliente.setId(id);
            clienteRepository.save(cliente);

            if (cliente.getTipoPessoa().equals(TipoPessoa.JURIDICA)) {
                return ClienteMapper.toPessoaJuridicaDTO(cliente);
            } else {
                return ClienteMapper.toPessoaFisicaDTO(cliente);
            }
        } else {
            throw new IllegalArgumentException("Cliente não encontrado com o ID fornecido.");
        }
    }

    public void deleteCliente(String id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado com o ID fornecido.");
        }
    }

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByCriteria(String razaoSocial, String nomeFantasia, String cnpj) {
        return clienteRepository.findByRazaoSocialContainingOrNomeFantasiaContainingOrCpfCnpjContaining(razaoSocial, nomeFantasia, cnpj);
    }

    private Cliente factoryCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setEnderecos(clienteDTO.endereco());
        cliente.setEmailPrincipal(clienteDTO.primaryEmail());
        cliente.setEmailSecundario(clienteDTO.secundaryEmail());
        cliente.setCpfCnpj(clienteDTO.paper());

        if (clienteDTO.tipoPessoa().equals(TipoPessoa.FISICA)) {
            cliente.setTipoPessoa(TipoPessoa.FISICA);
            cliente.setRazaoSocial(clienteDTO.name());
        } else {
            cliente.setTipoPessoa(TipoPessoa.JURIDICA);
            cliente.setNomeFantasia(clienteDTO.name());
        }

        return cliente;
    }
}
