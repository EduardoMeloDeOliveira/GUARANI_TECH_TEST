package api.guarani.api.domain.endereco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {
    @Column(name = "CLI_ENDERECO", length = 100)
    private String logradouro;

    @Column(name = "CLI_NUMERO", length = 20)
    private String numero;

    @Column(name = "CLI_COMPLEMENTO", length = 30)
    private String complemento;

    @Column(name = "CLI_BAIRRO", length = 80)
    private String bairro;

    @Column(name = "CLI_CODIGOMUNICIPIO", length = 10)
    private String codigoMunicipio;

    @Column(name = "CLI_CEP", length = 10)
    private String cep;

}
