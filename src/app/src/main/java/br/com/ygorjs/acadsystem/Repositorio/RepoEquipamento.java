package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.ygorjs.acadsystem.Conexao.Conexao;

/**
 * Created by ygorjohassonsilva on 23/11/2015.
 */
public class RepoEquipamento {

    private SQLiteDatabase db;
    private Conexao banco;

    public RepoEquipamento(Context context){
        banco = new Conexao(context);
    }


    public String incluirEquipamento(String nome, String descricao, String status, String marca){

        ContentValues values = new ContentValues();
        long resultado;

        db = banco.getWritableDatabase();

        values.put(Conexao.NOME_EQUIP,nome);
        values.put(Conexao.DESCRICAO_EQUIP,descricao);
        values.put(Conexao.STATUS_EQUIP,status);
        values.put(Conexao.MARCA_EQUIP,marca);

        resultado = db.insert(Conexao.TAB_EQUIP,null,values);

        return this.verificaResultado(resultado);

    }

    public String verificaResultado(long resultado){

        if(resultado == -1)
            return "Erro ao inserir";
        else
            return "Registro inserido com sucesso";
    }


    public Cursor mostrarEquipamento(){

        Cursor cursor;
        String[] campos = {

                banco.ID_EQUIP,
                banco.NOME_EQUIP,
                banco.DESCRICAO_EQUIP,
                banco.STATUS_EQUIP,
                banco.MARCA_EQUIP

        };

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TAB_EQUIP, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor carregaEquipById(int id){

        Cursor cursor;
        String[] campos = {

                banco.ID_EQUIP,
                banco.NOME_EQUIP,
                banco.DESCRICAO_EQUIP,
                banco.STATUS_EQUIP,
                banco.MARCA_EQUIP

        };


        String where = Conexao.ID_EQUIP+" = "+id;
        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_EQUIP,campos,where,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }


    public  void alterarEquipamento(int id, String nome, String descricao, String status, String marca){

        ContentValues values;
        String where;
        db = banco.getWritableDatabase();
        where = Conexao.ID_EQUIP +" = "+id;

        values = new ContentValues();
        values.put(Conexao.NOME_EQUIP,nome);
        values.put(Conexao.DESCRICAO_EQUIP,descricao);
        values.put(Conexao.STATUS_EQUIP,status);
        values.put(Conexao.MARCA_EQUIP,marca);

        db.update(Conexao.TAB_EQUIP,values,where,null);
        db.close();

    }


}
