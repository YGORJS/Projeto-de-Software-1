package br.com.ygorjs.acadsystem.Modelo;

/**
 * Created by ygorjohassonsilva on 23/11/2015.
 */
public class ModeloEquipamento {


    private String nome_Equip;
    private String descricao_Equip;
    private String status_Equip;
    private String marca_Equip;

    public void setNome_Equip(String nome_Equip){
        this.nome_Equip = nome_Equip;
    }

    public String getNome_Equip(){
        return this.nome_Equip;
    }

    public void setDescricao_Equip(String descricao_equip){
        this.descricao_Equip = descricao_equip;
    }

    public String getDescricao_Equip(){
        return this.descricao_Equip;
    }

    public void setStatus_Equip(String status_Equip){
        this.status_Equip = status_Equip;
    }

    public String getStatus_Equip(){
        return this.status_Equip;
    }

    public void setMarca_Equip(String marca_equip){
        this.marca_Equip = marca_equip;
    }

    public String getMarca_Equip(){
        return this.marca_Equip;
    }
}
