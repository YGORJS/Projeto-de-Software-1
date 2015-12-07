package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.ygorjs.acadsystem.Conexao.Conexao;

/**
 * Created by ygorjohassonsilva on 22/11/2015.
 */
public class RepoExercicio {

    private SQLiteDatabase db;
    private Conexao banco;

    public RepoExercicio(Context context){
        banco = new Conexao(context);
    }

    public String incluirExercicio(String nome, String descricao, String status){

        ContentValues values = new ContentValues();
        long resultado;

        db = banco.getWritableDatabase();

        values.put(Conexao.NOME,nome);
        values.put(Conexao.STATUS,status);
        values.put(Conexao.DESCRICAO,descricao);

        resultado = db.insert(Conexao.TABELA,null,values);


        return this.verificaResultado(resultado);

    }


    public String verificaResultado(long resultado){

        if(resultado == -1)
            return "Erro ao inserir";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor mostrarExercicio(){

        Cursor cursor;
        String[] campos = {
                banco.ID,
                banco.NOME
        };

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

                if(cursor != null){
                    cursor.moveToFirst();
                }
        db.close();
        return cursor;
    }

    public  void alterarExercicio(int id, String nome, String descricao, String status){

        ContentValues values;
        String where;
        db = banco.getWritableDatabase();
        where = Conexao.ID+" = "+id;

        values = new ContentValues();
        values.put(Conexao.NOME,nome);
        values.put(Conexao.STATUS,status);
        values.put(Conexao.DESCRICAO,descricao);

        db.update(Conexao.TABELA,values,where,null);
        db.close();

    }
}


