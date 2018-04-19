package br.casadocodigo.loja.controllers;

import br.casadocodigo.loja.models.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;

@RequestMapping("/controle")
@Controller

public class PagamentoController implements Serializable {

    @Autowired
    CarrinhoCompras carrinho;

    @RequestMapping(value = "carrinho/finalizar" , method =  RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes model){
       ModelAndView modelAndView  = new ModelAndView();
       model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso !");

       return new ModelAndView("redirect:/produtos");
    }
}
