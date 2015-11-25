package br.com.ygorjs.acadsystem.Repositorio;

import android.content.ContentValues;
import android.content.Context;
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

}
