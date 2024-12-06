package api.tech.chalange.api.domain.produto.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gua_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRO_CODIGOEMPRESA", length = 10, nullable = false)
    private String codigoEmpresa;

    @Column(name = "PRO_CODIGO", length = 30, nullable = false)
    private String codigo;

    @Column(name = "PRO_CODIGOMARCA", length = 10)
    private String codigoMarca;

    @Column(name = "PRO_CODIGOGRUPO", length = 10)
    private String codigoGrupo;

    @Column(name = "PRO_DESCRICAO", length = 100, nullable = false)
    private String descricao;

    @Column(name = "PRO_STATUS", length = 1)
    private String status;

    @Column(name = "PRO_DUN14", length = 50)
    private String dun14;

    @Column(name = "PRO_EAN13", length = 50)
    private String ean13;

    @Column(name = "PRO_PESOBRUTO", precision = 10, scale = 2)
    private BigDecimal pesoBruto;

    @Column(name = "PRO_QTDEEMBALAGEM")
    private Integer quantidadeEmbalagem;

    @Column(name = "PRO_VOLUME", length = 30)
    private String volume;

    @Column(name = "PRO_OBSERVACAO", length = 200)
    private String observacao;

    @Column(name = "PRO_UNIDPRODUTO", length = 30)
    private String unidadeProduto;

    @Column(name = "PRO_TEMPOVALIDADE", length = 30)
    private String tempoValidade;

    @Column(name = "PRO_PERCCOMISSAO", precision = 6, scale = 2)
    private BigDecimal percentualComissao;

    @Column(name = "PRO_FLAGVALORFIXO", length = 1)
    private String flagValorFixo;

    @Column(name = "PRO_QTDEMINIMAVENDA", precision = 10, scale = 2)
    private BigDecimal quantidadeMinimaVenda;

    @Column(name = "PRO_QTDEMULTIPLOVENDA", precision = 10, scale = 2)
    private BigDecimal quantidadeMultiploVenda;

    @Column(name = "PRO_PRECUSTO", precision = 12, scale = 2)
    private BigDecimal precoCusto;

    @Column(name = "PRO_REFERENCIA", length = 20)
    private String referencia;

    @Column(name = "PRO_CODIGOFORNECEDOR", length = 20)
    private String codigoFornecedor;

    @Column(name = "PRO_EMBALAGENS", length = 250)
    private String embalagens;

    @Column(name = "PRO_SITESTOQUE")
    private Integer situacaoEstoque;

    @Column(name = "PRO_IPI", precision = 5, scale = 2)
    private BigDecimal ipi;

    @Column(name = "PRO_MKPMINIMO", precision = 5, scale = 2)
    private BigDecimal mkpMinimo;

    @Column(name = "PRO_RAMOSATIVIDADE", length = 250)
    private String ramosAtividade;

    @Column(name = "PRO_SEGMENTO", length = 10)
    private String segmento;

    @Column(name = "PRO_LINHA", length = 10)
    private String linha;

    @Column(name = "PRO_NCM", length = 10)
    private String ncm;

    @Column(name = "PRO_SEGREGACAO")
    private Integer segregacao;

    @Column(name = "PRO_EMPRESAFAT", length = 255)
    private String empresaFat;

    @Column(name = "PRO_ESTOQUEMINIMO", precision = 12, scale = 2)
    private BigDecimal estoqueMinimo;

    @Column(name = "PRO_CODIGOSUBGRUPO", length = 10)
    private String codigoSubgrupo;

    @Column(name = "PRO_CORLEGENDANORMAL", length = 2)
    private String corLegendaNormal;

    @Column(name = "PRO_TIPOPEDIDOS", length = 100)
    private String tipoPedidos;

    @Column(name = "PRO_DESEMBUTEIPI", length = 1)
    private String desembuteIpi;

    @Column(name = "PRO_CLA", length = 100)
    private String cla;

    @Column(name = "PRO_TROCAPROIBIDA", length = 1)
    private String trocaProibida;

    @Column(name = "PRO_GIRO")
    private Integer giro;

    @Column(name = "PRO_RETORNO", length = 15)
    private String retorno;

    @Column(name = "PRO_DESPESAOPERACIONAL", precision = 5, scale = 2)
    private BigDecimal despesaOperacional;

    @Column(name = "PRO_CONTRIBUICAOMINIMA", precision = 5, scale = 2)
    private BigDecimal contribuicaoMinima;

    @Column(name = "PRO_DESCRICAOPDF", length = 255)
    private String descricaoPdf;

    @Column(name = "PRO_VRAQUISICAO", precision = 15, scale = 2)
    private BigDecimal vraquisicao;

    @Column(name = "PRO_DESCRICAOLONGA", length = 100)
    private String descricaoLonga;

    @Column(name = "PRO_FICHA_DADOS", length = 4096)
    private String fichaDados;

    @Column(name = "PRO_CODIGOCEST", length = 30)
    private String codigoCest;

    @Column(name = "PRO_CONTRIBUICAOIDEAL", precision = 5, scale = 2)
    private BigDecimal contribuicaoIdeal;

    @Column(name = "PRO_PRAZOSPERMITIDOS", length = 100)
    private String prazosPermitidos;

    @Column(name = "PRO_COR", length = 30)
    private String cor;

    @Column(name = "PRO_TAMANHO", length = 30)
    private String tamanho;

    @Column(name = "PRO_BLOQPRODSEMEST")
    private Integer bloqueioProdutoSemEstoque;

    @Column(name = "PRO_DATASUSPENSAOINICIAL", length = 10)
    private String dataSuspensaoInicial;

    @Column(name = "PRO_DATASUSPENSAOFINAL", length = 10)
    private String dataSuspensaoFinal;

    @Column(name = "PRO_QTDSEGRSELECAO")
    private Integer quantidadeSegurancaSelecao;

    @Column(name = "PRO_RAMOSATIVIDADEEXCLUSIVO")
    private String ramosAtividadeExclusivo;

    @Column(name = "PRO_TIPOMEDICAMENTO", length = 1)
    private String tipoMedicamento;

    @Column(name = "PRO_CLA_EMB", length = 100)
    private String claEmb;

    @Column(name = "PRO_PRECOMINIMO", precision = 15, scale = 2)
    private BigDecimal precoMinimo;

    @Column(name = "PRO_LINK")
    private String link;
}
