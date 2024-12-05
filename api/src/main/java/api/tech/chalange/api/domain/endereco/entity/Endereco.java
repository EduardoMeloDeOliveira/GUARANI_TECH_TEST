package api.tech.chalange.api.domain.endereco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {

    @Column(name = "cli_endereco", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "cli_numero", length = 20, nullable = false)
    private String numero;

    @Column(name = "cli_complemento", length = 30)
    private String complemento;

    @Column(name = "cli_bairro", length = 80, nullable = false)
    private String bairro;

    @Column(name = "cli_codMunicipio", length = 10, nullable = false)
    private String codigoMunicipio;

    @Column(name = "cli_cep", length = 10, nullable = false)
    private String cep;

    // Getters e setters
    // Construtor
}