package api.guarani.api.domain.cliente.repository;

import api.guarani.api.domain.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
