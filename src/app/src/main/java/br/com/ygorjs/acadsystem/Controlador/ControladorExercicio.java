package br.com.ygorjs.acadsystem.Controlador;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.Repositorio.RepoExercicio;

/**
 * Created by ygorjohassonsilva on 22/11/2015.
 */
public class ControladorExercicio {

    private String resultado = "";
    private RepoExercicio crud ;

    public void inserirExercicio(EditText nome, EditText descricao, EditText status, Context context){


        crud = new RepoExercicio(context.getApplicationContext());
        String nomeA = nome.getText().toString();
        String statusA= status.getText().toString();
        String descricaoA = descricao.getText().toString();

        this.resultado = crud.incluirExercicio(nomeA,descricaoA,statusA);
        Toast.makeText(context.getApplicationContext(),resultado,Toast.LENGTH_LONG).show();

        this.fieldEmpty(nome,descricao,status);

    }

    private void fieldEmpty(EditText nome, EditText descricao,EditText status){

        nome.setText("");
        descricao.setText("");
        status.setText("");
    }

}
