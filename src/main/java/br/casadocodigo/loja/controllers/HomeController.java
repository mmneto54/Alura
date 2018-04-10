package br.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller
 * Associada com classes que possuem métodos que processam requests numa aplicação web.
 */
@Controller
public class HomeController {

     @RequestMapping("/")
     public String index (){
         System.out.println("Entrando na home da casadocodigo");
         return "home";
    }
}
