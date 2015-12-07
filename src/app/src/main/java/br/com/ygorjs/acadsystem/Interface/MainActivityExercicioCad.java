package br.com.ygorjs.acadsystem.Interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ygorjs.acadsystem.Controlador.ControladorExercicio;
import br.com.ygorjs.acadsystem.R;

public class MainActivityExercicioCad extends AppCompatActivity {

    private ControladorExercicio crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        crud = new ControladorExercicio();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_exercicio_cad);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome = (EditText) findViewById(R.id.et_nome_exer);
                EditText descricao = (EditText) findViewById(R.id.et_descricao_exer);
                EditText status = (EditText) findViewById(R.id.et_status_exer);

                crud.inserirExercicio(nome, descricao, status, getBaseContext());
            }
        });
    }
}
