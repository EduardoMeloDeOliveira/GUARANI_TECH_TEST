package api.tech.chalange.api.domain.cliente.repository;

import api.tech.chalange.api.domain.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByRazaoSocialContainingOrNomeFantasiaContainingOrCpfCnpjContaining(String razaoSocial, String nomeFantasia, String cnpj);

}
