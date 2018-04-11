package br.casadocodigo.loja.controllers;

import br.casadocodigo.loja.models.Produto;
import br.casadocodigo.loja.models.TipoPreco;

public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipo;


    public CarrinhoItem(Produto produto, TipoPreco tipo) {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }
}
