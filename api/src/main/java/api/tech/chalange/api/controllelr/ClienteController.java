package api.tech.chalange.api.controllelr;


import api.tech.chalange.api.domain.cliente.dto.ClienteBaseDTO;
import api.tech.chalange.api.domain.cliente.dto.ClienteDTO;
import api.tech.chalange.api.domain.cliente.entity.Cliente;
import api.tech.chalange.api.domain.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteBaseDTO saveCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteBaseDTO updateCliente(@PathVariable String id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.updateCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable String id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }

    @GetMapping("/search")
    public List<Cliente> findByCriteria(
            @RequestParam(required = false) String razaoSocial,
            @RequestParam(required = false) String nomeFantasia,
            @RequestParam(required = false) String cnpj) {
        return clienteService.findByCriteria(razaoSocial, nomeFantasia, cnpj);
    }
}