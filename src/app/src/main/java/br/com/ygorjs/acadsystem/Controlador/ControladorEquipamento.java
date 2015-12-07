package br.com.ygorjs.acadsystem.Controlador;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Repositorio.RepoEquipamento;
import br.com.ygorjs.acadsystem.Repositorio.RepoExercicio;

/**
 * Created by ygorjohassonsilva on 23/11/2015.
 */
public class ControladorEquipamento {

    private String resultado = "";
    private RepoEquipamento crud ;

    public void inserirEquipamento(EditText nome, EditText descricao, EditText status, EditText marca, Context context){


        crud = new RepoEquipamento(context.getApplicationContext());

        String nome_Equip = nome.getText().toString();
        String status_Equip= status.getText().toString();
        String descricao_Equip = descricao.getText().toString();
        String marca_Equip = marca.getText().toString();

        this.resultado = crud.incluirEquipamento(nome_Equip,descricao_Equip,status_Equip,marca_Equip);
        Toast.makeText(context.getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

        this.fieldEmpty(nome,descricao,status,marca);

    }


    private void fieldEmpty(EditText nome, EditText descricao, EditText status, EditText marca){

        nome.setText("");
        descricao.setText("");
        status.setText("");
        marca.setText("");
    }

}
