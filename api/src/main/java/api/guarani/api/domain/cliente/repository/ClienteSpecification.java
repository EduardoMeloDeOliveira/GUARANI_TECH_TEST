package api.guarani.api.domain.cliente.repository;

import api.guarani.api.domain.cliente.entity.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class ClienteSpecification {

    public static Specification<Cliente> hasRazaoSocial(String razaoSocial) {
        return (root, query, criteriaBuilder) -> {
            if (razaoSocial != null && !razaoSocial.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("razaoSocial")), "%" + razaoSocial.toLowerCase() + "%");
            }
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Cliente> hasNomeFantasia(String nomeFantasia) {
        return (root, query, criteriaBuilder) -> {
            if (nomeFantasia != null && !nomeFantasia.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("nomeFantasia")), "%" + nomeFantasia.toLowerCase() + "%");
            }
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Cliente> hasCnpj(String cnpj) {
        return (root, query, criteriaBuilder) -> {
            if (cnpj != null && !cnpj.isEmpty()) {
                return criteriaBuilder.equal(root.get("cpfCnpj"), cnpj);
            }
            return criteriaBuilder.conjunction();
        };
    }
}
