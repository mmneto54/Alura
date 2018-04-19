package br.casadocodigo.loja.controllers;


import br.casadocodigo.loja.dao.ProdutoDAO;
import br.casadocodigo.loja.models.CarrinhoCompras;
import br.casadocodigo.loja.models.Produto;
import br.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
@Scope(value= WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {


    @Autowired
    private ProdutoDAO produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId , TipoPreco tipo){

        ModelAndView modelAndView = new ModelAndView("/carrinho/itens");
        CarrinhoItem  carrinhoItem =  criaItem(produtoId,tipo);
        System.out.println("carrinhoItem.getProduto().getId() " + carrinhoItem.getProduto().getId());
        System.out.println("carrinhoItem.getProduto().getId() " + carrinhoItem.getTipo().name()  );
        carrinho.add(carrinhoItem);

     return modelAndView;
    }

    public CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){

        Produto produto = produtoDao.find(produtoId);

        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
        return carrinhoItem;

    }
    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView itens(){
        return new ModelAndView("/carrinho/itens");

    }

    @RequestMapping("/remover")
    public ModelAndView remover(Integer produtoId , TipoPreco tipoPreco ){
        carrinho.remover(produtoId , tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }


}


