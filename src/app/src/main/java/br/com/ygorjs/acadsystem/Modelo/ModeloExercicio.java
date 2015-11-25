package br.com.ygorjs.acadsystem.Modelo;

/**
 * Created by ygorjohassonsilva on 18/11/2015.
 */
public class ModeloExercicio {

    private String nome;
    private char status;
    private String descricao;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setStatus(char status){
        this.status = status;
    }

    public char getStatus(){
        return this.status;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }




}
