package api.guarani.api.domain.cliente.service;

import api.guarani.api.domain.cliente.dto.ClienteResponse;
import api.guarani.api.domain.cliente.entity.Cliente;
import api.guarani.api.domain.cliente.mapper.ClienteMapper;
import api.guarani.api.domain.cliente.repository.ClienteRepository;
import api.guarani.api.domain.cliente.repository.ClienteSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteResponse cadastrarCliente(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        return ClienteMapper.mapToResponse(savedCliente);
    }

    @Transactional
    public ClienteResponse atualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            Cliente updatedCliente = existingCliente.get();
            updatedCliente.setRazaoSocial(cliente.getRazaoSocial());
            updatedCliente.setNomeFantasia(cliente.getNomeFantasia());
            updatedCliente.setCpfCnpj(cliente.getCpfCnpj());
            clienteRepository.save(updatedCliente);
            return ClienteMapper.mapToResponse(updatedCliente);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    @Transactional
    public void deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public ClienteResponse buscarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(ClienteMapper::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<ClienteResponse> buscarClientes(String razaoSocial, String nomeFantasia, String cnpj) {
        Specification<Cliente> specification = Specification.where(ClienteSpecification.hasRazaoSocial(razaoSocial))
                .and(ClienteSpecification.hasNomeFantasia(nomeFantasia))
                .and(ClienteSpecification.hasCnpj(cnpj));

        List<Cliente> clientes = clienteRepository.findAll((Sort) specification);
        return clientes.stream()
                .map(ClienteMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<ClienteResponse> listarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteMapper::mapToResponse)
                .collect(Collectors.toList());
    }
}
