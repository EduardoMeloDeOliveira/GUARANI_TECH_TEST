package api.tech.chalange.api.domain.cliente.entity;

import api.tech.chalange.api.domain.cliente.enums.TipoPessoa;
import api.tech.chalange.api.domain.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gua_clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cli_codigoCliente")
    private String id;

    @Column(name = "cli_razaoSocial", length = 100, nullable = false)
    private String razaoSocial;

    @Column(name = "cli_cgccpf", length = 20, nullable = false)
    private String cpfCnpj;

    @Column(name = "cli_nomeFantasia", length = 50)
    private String nomeFantasia;

    @Column(name = "cli_email", length = 100, nullable = false)
    private String emailPrincipal;

    @Column(name = "cli_emailSecundario", length = 100)
    private String emailSecundario;

    @Enumerated(EnumType.STRING)
    @Column(name = "cli_tipoPessoa", length = 1, nullable = false)
    private TipoPessoa tipoPessoa;

    @ElementCollection
    @CollectionTable(name = "cliente_enderecos", joinColumns = @JoinColumn(name = "cli_codigoCliente"))
    private List<Endereco> enderecos = new ArrayList<>();

    public List<Endereco> getEnderecos() {
        return enderecos == null ? new ArrayList<>() : enderecos;
    }




}
