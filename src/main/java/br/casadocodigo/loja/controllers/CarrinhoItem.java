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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CarrinhoItem{");
        sb.append("produto=").append(produto);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarrinhoItem)) return false;

        CarrinhoItem that = (CarrinhoItem) o;

        if (getProduto() != null ? !getProduto().equals(that.getProduto()) : that.getProduto() != null) return false;
        return getTipo() == that.getTipo();
    }

    @Override
    public int hashCode() {
        int result = getProduto() != null ? getProduto().hashCode() : 0;
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        return result;
    }
}
