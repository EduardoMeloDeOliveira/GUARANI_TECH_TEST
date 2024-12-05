package api.tech.chalange.api.domain.cliente.repository;

import api.tech.chalange.api.domain.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
