package br.casadocodigo.loja.controllers;


import br.casadocodigo.loja.dao.ProdutoDAO;
import br.casadocodigo.loja.models.CarrinhoCompras;
import br.casadocodigo.loja.models.Produto;
import br.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {


    @Autowired
    private ProdutoDAO produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId , TipoPreco tipo){

        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem  carrinhoItem =  criaItem(produtoId,tipo);
        carrinho.add(carrinhoItem);

     return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){

        Produto produto = produtoDao.find(produtoId);

        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
        return carrinhoItem;

    }


}


