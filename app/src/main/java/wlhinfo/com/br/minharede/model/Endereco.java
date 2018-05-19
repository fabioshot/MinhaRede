package wlhinfo.com.br.minharede.model;

import java.security.PublicKey;

/**
 * Created by fabio on 15/04/18.
 */

public class Endereco {
    private Integer codigo;
    private String ip;
    private Empresa empresa;
    private String equipamento;

    public Endereco(Integer codigo, String ip, Empresa empresa, String equipamento){
        this.codigo = codigo;
        this.ip = ip;
        this.empresa = empresa;
        this.equipamento = equipamento;
     }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getEquipamento() {return equipamento;}

    public void setEquipamento(String equipamento) {this.equipamento = equipamento;}


}
