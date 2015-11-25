package br.com.ygorjs.acadsystem.Modelo;

/**
 * Created by ygorjohassonsilva on 18/11/2015.
 */
public class ModeloUsuario {

    private String nome;
    private char tipoUsuario;
    private char sexo;
    private String endereco;
    private String bairro;
    private  char status;
    private String login;
    private String senha;
    private String dtIncl;
    private String dtAtlz;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setTipoUsuario(char tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public char getTipoUsuario(){
        return this.tipoUsuario;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public char getSexo(){
        return this.sexo;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getBairro(){
        return this.bairro;
    }



    public void setStatus(char status){
        this.status = status;
    }

    public char getStatus(){
        return this.status;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setDtIncl(String dtIncl){this.dtIncl = dtIncl;}

    public String getDtIncl(){
        return dtIncl;
    }

    public void setDtAtlz(String dtAtlz){
        this.dtAtlz = dtAtlz;
    }






}
