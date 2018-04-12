package br.casadocodigo.loja.controllers;


import br.casadocodigo.loja.dao.ProdutoDAO;
import br.casadocodigo.loja.infra.FileSarver;
import br.casadocodigo.loja.models.Produto;
import br.casadocodigo.loja.models.TipoPreco;
import br.casadocodigo.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private FileSarver fileSaver;

    @InitBinder
    public void  InitBindder(WebDataBinder dataBinder){
        dataBinder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("form")
    public ModelAndView form (Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario ,@Valid Produto produto , BindingResult bindingResult, RedirectAttributes redirectAttributes){

        new FileSarver();

        if (bindingResult.hasErrors()) return form(produto);


        String path = fileSaver.write("arquivos-sumario", sumario);
        produto.setSumarioPath(path);

        produtoDAO.gravar(produto);

        ModelAndView modelAndView = new ModelAndView("redirect:produtos");
        redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso !");
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar (){
        List<Produto> produtos  = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @RequestMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") Integer id){

        ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
        Produto produto  = produtoDAO.find(id);
        modelAndView.addObject("produto", produto);

        return modelAndView;

    }


}

