package br.casadocodigo.loja.models;

import br.casadocodigo.loja.controllers.CarrinhoItem;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();


    public void add (CarrinhoItem item){
        itens.put(item, getQuantidade(item) + 1);
    }

    private int getQuantidade(CarrinhoItem item) {
        if(!itens.containsKey(item)){
            itens.put(item, 0);
        }
        return itens.get(item);
    }
}
