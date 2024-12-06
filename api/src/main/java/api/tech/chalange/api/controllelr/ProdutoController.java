package api.tech.chalange.api.controllelr;


import api.tech.chalange.api.domain.produto.dto.ProdutoResDTO;
import api.tech.chalange.api.domain.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<ProdutoResDTO> buscarProdutos(
            @RequestParam(required = false) String empresaId,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) Double estoqueMinimo,
            @RequestParam(required = false) Double precoMinimo) {
        return produtoService.buscarProdutos( codigo, codigo, estoqueMinimo, precoMinimo);
    }
}
