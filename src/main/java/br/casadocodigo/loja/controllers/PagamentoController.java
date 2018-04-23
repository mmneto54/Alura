package br.casadocodigo.loja.controllers;

import br.casadocodigo.loja.models.CarrinhoCompras;
import br.casadocodigo.loja.models.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;
import java.util.concurrent.Callable;

@RequestMapping("/controle")
@Controller

public class PagamentoController implements Serializable {

    @Autowired
    CarrinhoCompras carrinho;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "carrinho/finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model) {

        return () -> {

            try {
                String uri = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);

                model.addFlashAttribute("sucesso", response);
                System.out.println(response);

                ModelAndView modelAndView = new ModelAndView();
                model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso !");

            } catch (HttpClientErrorException e) {

                e.printStackTrace();
                model.addFlashAttribute("falha", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }

            return new ModelAndView("redirect:/produtos");
        };

    }
}
