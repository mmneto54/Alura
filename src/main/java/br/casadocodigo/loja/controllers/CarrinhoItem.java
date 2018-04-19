package br.casadocodigo.loja.controllers;

import br.casadocodigo.loja.models.Produto;
import br.casadocodigo.loja.models.TipoPreco;

import java.math.BigDecimal;

public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipo;


    public CarrinhoItem(Produto produto, TipoPreco tipo) {
        this.produto = produto;
        this.tipo = tipo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco(){
        return produto.precoPara(getTipo());
    }


    public BigDecimal getTotal(int quantidade) {
        return this.getPreco().multiply(new BigDecimal(quantidade));
    }


    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CarrinhoItem{");
        sb.append("produto=").append(produto);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
