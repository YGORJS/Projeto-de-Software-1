package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        values.put(Conexao.NOME_EXER,nome);
        values.put(Conexao.STATUS_EXER,status);
        values.put(Conexao.DESCRICAO_EXER,descricao);

        resultado = db.insert(Conexao.TAB_EXER,null,values);


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
                banco.ID_EXER,
                banco.NOME_EXER,
                banco.DESCRICAO_EXER,
                banco.STATUS_EXER
        };

        db = banco.getReadableDatabase();
        cursor = db.query(banco.TAB_EXER, campos, null, null, null, null, null, null);

                if(cursor != null){
                    cursor.moveToFirst();
                }
        db.close();
        return cursor;
    }



    public Cursor carregaExerById(int id){

        Cursor cursor;
        String [] campos = {

                banco.ID_EXER,
                banco.NOME_EXER,
                banco.DESCRICAO_EXER,
                banco.STATUS_EXER
        };

        String where = Conexao.ID_EXER+" = "+id;
        db = banco.getReadableDatabase();
        cursor = db.query(Conexao.TAB_EXER,campos,where,null,null,null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }



    public  void alterarExercicio(int id, String nome, String descricao, String status){

        ContentValues values;
        String where;
        db = banco.getWritableDatabase();
        where = Conexao.ID_EXER +" = "+id;

        values = new ContentValues();
        values.put(Conexao.NOME_EXER,nome);
        values.put(Conexao.STATUS_EXER,status);
        values.put(Conexao.DESCRICAO_EXER,descricao);

        db.update(Conexao.TAB_EXER,values,where,null);
        db.close();

    }
}


