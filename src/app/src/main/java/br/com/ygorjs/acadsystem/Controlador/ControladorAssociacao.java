package br.com.ygorjs.acadsystem.Controlador;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Repositorio.RepoAssociacao;

/**
 * Created by ygorjohassonsilva on 29/11/2015.
 */
public class ControladorAssociacao {

    private String resultado = "";
    private RepoAssociacao crud;

    public void incluirAssociacao(EditText cliente, EditText exercicio, EditText equipamento, Context context){

        crud = new RepoAssociacao(context.getApplicationContext());

        String clienteA = cliente.getText().toString();
        String exercicioA = exercicio.getText().toString();
        String equipamentoA = equipamento.getText().toString();

        this.resultado = crud.incluirAssociacao(clienteA,exercicioA,equipamentoA);

        Toast.makeText(context.getApplicationContext(),resultado,Toast.LENGTH_LONG).show();

        this.fieldEmpty(cliente,exercicio,equipamento);
    }


    private void fieldEmpty(EditText cliente, EditText exercicio,EditText equipamento){

        cliente.setText("");
        exercicio.setText("");
        equipamento.setText("");
    }
}
