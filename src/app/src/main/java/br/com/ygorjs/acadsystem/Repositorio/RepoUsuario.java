package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.Controlador.ControladorEquipamento;

/**
 * Created by ygorjohassonsilva on 24/11/2015.
 */
public class RepoUsuario {

    private SQLiteDatabase db;
    private Conexao banco;


    public RepoUsuario(Context context){

        banco = new Conexao(context);
    }


    public String incluirUsuario(String nome, String tipo_Usuario, String sexo, String endereco, String bairro, String cidade, String estado, String status, String login, String senha){

        ContentValues values = new ContentValues();
        long resultado;

        db = banco.getWritableDatabase();

        values.put(Conexao.NOME_USUR,nome);
        values.put(Conexao.TIPO_USUR,tipo_Usuario);
        values.put(Conexao.SEXO_USUR,sexo);
        values.put(Conexao.ENDERECO_USUR, endereco);
        values.put(Conexao.BAIRRO_USUR, bairro);
        values.put(Conexao.CIDADE_USUR, cidade);
        values.put(Conexao.ESTADO_USUR, estado);
        values.put(Conexao.STATUS_USUR,status);
        values.put(Conexao.LOGIN_USUR,login);
        values.put(Conexao.SENHA_USUR, senha);


        resultado = db.insert(Conexao.TAB_USUR,null,values);


        return this.verificaResultado(resultado);

    }


    public String verificaResultado(long resultado){

        if(resultado == -1)
            return "Erro ao inserir";
        else
            return "Registro inserido com sucesso";
    }

}
