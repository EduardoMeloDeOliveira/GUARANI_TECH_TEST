package api.guarani.api.domain.cliente.entity;

import api.guarani.api.domain.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "GUA_CLIENTES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cliente {

    @Id
    @Column(name = "CLI_CODIGOCLIENTE", nullable = false)
    private Long id;

    @Column(name = "CLI_RAZAOSOCIAL", length = 100)
    private String razaoSocial;

    @Column(name = "CLI_NOMEFANTASIA", length = 50)
    private String nomeFantasia;

    @Column(name = "CLI_CGCCPF", length = 20, nullable = false)
    private String cpfCnpj;

    @Column(name = "CLI_EMAIL", length = 100)
    private String emailPrincipal;

    @Column(name = "CLI_EMAILSECUNDARIO", length = 100)
    private String emailSecundario;

    @Column(name = "CLI_TELEFONE", length = 20)
    private String telefone;

    @Column(name = "CLI_DATACADASTRO")
    private LocalDate dataCadastro;

    @Column(name = "CLI_STATUS", length = 10)
    private String status;

    @Column(name = "CLI_TIPOPESSOA", length = 1)
    private String tipoPessoa;

    @ElementCollection
    @CollectionTable(name = "CLIENTE_ENDERECOS", joinColumns = @JoinColumn(name = "CLI_CODIGOCLIENTE"))
    private List<Endereco> enderecos;


}
