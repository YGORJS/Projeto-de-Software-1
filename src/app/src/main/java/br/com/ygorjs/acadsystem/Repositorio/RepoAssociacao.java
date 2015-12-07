package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.net.IDN;

import br.com.ygorjs.acadsystem.Conexao.Conexao;

/**
 * Created by ygorjohassonsilva on 29/11/2015.
 */
public class RepoAssociacao {

    private SQLiteDatabase db;
    private Conexao banco;


    public RepoAssociacao(Context context){
        banco = new Conexao(context);
    }


    public String incluirAssociacao(String cliente, String exercico, String equipamento ){

        ContentValues values = new ContentValues();
        long resultado;

        db= banco.getWritableDatabase();

        values.put(Conexao.NOME_USUR_ASSOC, cliente);
        values.put(Conexao.NOME_EQUIP_ASSOC,equipamento);
        values.put(Conexao.NOME_EXER_ASSOC,exercico);

        resultado = db.insert(Conexao.TAB_ASSC,null,values);

        return this.resultado(resultado );

    }

    public String resultado(long resultado){

        if(resultado == -1)
            return "Erro ao inserir";
        else
            return "Registro inserido com sucesso";

    }


    public Cursor mostrarAssociacao(){

        Cursor cursor;
        String campos [] = {
            banco.ID_ASSOC,
            banco.NOME_EQUIP_ASSOC,
            banco.NOME_EXER_ASSOC,
            banco.NOME_USUR_ASSOC
        };

        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_ASSC,campos,null,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }

    public Cursor carregaAssocById(int id){

        Cursor cursor;
        String [] campos = {banco.ID_ASSOC,banco.NOME_EQUIP_ASSOC,banco.NOME_EXER_ASSOC,banco.NOME_USUR_ASSOC};

        String where = Conexao.ID_ASSOC+" = "+id;
        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_ASSC,campos,where,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }


    public void alterarAssociacao(int id, String cliente, String exercicio, String equipamento){

        ContentValues values;
        String where;
        db = banco.getWritableDatabase();

        where = Conexao.ID_ASSOC+" = "+ id;

        values = new ContentValues();
        values.put(Conexao.NOME_USUR_ASSOC,cliente);
        values.put(Conexao.NOME_EXER_ASSOC,exercicio);
        values.put(Conexao.NOME_EQUIP_ASSOC,equipamento);

        db.update(Conexao.TAB_ASSC,values,where,null);
        db.close();


    }

}
