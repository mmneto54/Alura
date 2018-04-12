package br.casadocodigo.loja.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


@Entity
public class Produto {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;
    private String  titulo;
    private String  descricao;
    private String  pagina;
    private String  sumarioPath;

    @DateTimeFormat
    private Calendar dataLancamento;

    @ElementCollection
    private List<Preco> precos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getSumarioPath() {
        return sumarioPath;
    }

    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }

    public BigDecimal precoPara(TipoPreco tipoPreco) {
        return precos.stream().filter(preco -> preco.getTipoPreco().equals(tipoPreco)).findFirst().get().getValor();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto produto = (Produto) o;

        return getId() == produto.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produto{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", pagina='").append(pagina).append('\'');
        sb.append('}');
        return sb.toString();
    }


}




