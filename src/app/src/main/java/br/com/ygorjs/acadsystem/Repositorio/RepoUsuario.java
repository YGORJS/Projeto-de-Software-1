package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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


    public Cursor mostrarUsuario(){

        Cursor cursor;
        String campos [] = {
                banco.ID_USUR,
                banco.NOME_USUR,
                banco.TIPO_USUR,
                banco.SEXO_USUR,
                banco.ENDERECO_USUR,
                banco.BAIRRO_USUR,
                banco.CIDADE_USUR,
                banco.ESTADO_USUR,
                banco.STATUS_USUR,
                banco.LOGIN_USUR,
                banco.SENHA_USUR
        };

        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_USUR,campos,null,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }


    public Cursor carregaUsurById(int id){

        Cursor cursor;
        String [] campos = {
                banco.ID_USUR,
                banco.NOME_USUR,
                banco.TIPO_USUR,
                banco.SEXO_USUR,
                banco.ENDERECO_USUR,
                banco.BAIRRO_USUR,
                banco.CIDADE_USUR,
                banco.ESTADO_USUR,
                banco.STATUS_USUR,
                banco.LOGIN_USUR,
                banco.SENHA_USUR

        };

        String where = Conexao.ID_USUR+" = "+id;
        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_USUR,campos,where,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }



    public void alterarUsuario(int id, String nome, String tipoUsuario , String sexo, String endereco, String bairro, String cidade , String estado, String status, String login , String senha){

        ContentValues values;
        String where;
        db = banco.getWritableDatabase();

        where = Conexao.ID_USUR+" = "+ id;

        values = new ContentValues();

        values.put(Conexao.NOME_USUR,nome);
        values.put(Conexao.TIPO_USUR,tipoUsuario);
        values.put(Conexao.SEXO_USUR, sexo);
        values.put(Conexao.ENDERECO_USUR,endereco);
        values.put(Conexao.BAIRRO_USUR,bairro);
        values.put(Conexao.CIDADE_USUR,cidade);
        values.put(Conexao.ESTADO_USUR,estado);
        values.put(Conexao.STATUS_USUR,status);
        values.put(Conexao.LOGIN_USUR,login);
        values.put(Conexao.SENHA_USUR,senha);


        db.update(Conexao.TAB_USUR,values,where,null);
        db.close();


    }




}
