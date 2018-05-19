package wlhinfo.com.br.minharede.model;

import android.widget.EditText;

/**
 * Created by fabio on 15/04/18.
 */

public class Empresa {

    private Integer codigo;
    private String gateway;
    private String mascara;
    private String nome;


    public Integer getCodigo() {return codigo;}

    public void setCodigo(Integer codigo) {this.codigo = codigo;}

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
