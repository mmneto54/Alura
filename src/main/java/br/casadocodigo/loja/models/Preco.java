package br.casadocodigo.loja.models;


import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @Embeddable
 *  E para que o Spring possa relacionar e portar os elementos de preço para dentro da coleção  @ElementCollection do
 *  List<Preco> precos  que está na classe Produto ;
 */

@Embeddable
public class Preco {

   private BigDecimal valor;
   private TipoPreco  tipoPreco;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }
}
