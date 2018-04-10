package br.casadocodigo.loja.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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




