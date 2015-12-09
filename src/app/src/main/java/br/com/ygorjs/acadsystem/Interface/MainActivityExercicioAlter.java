package br.com.ygorjs.acadsystem.Interface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.R;
import br.com.ygorjs.acadsystem.Repositorio.RepoExercicio;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityExercicioAlter extends AppCompatActivity {


    private EditText nomeExer;
    private EditText descricaoExer;
    private EditText statusExer;

    private Button alterar;
    private Cursor cursor;
    private RepoExercicio crud;
    private String codigo;



    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.content_main_exercicio_alter);


        codigo = getIntent().getStringExtra("codigo");
        crud = new RepoExercicio(getBaseContext());

        nomeExer = (EditText)findViewById(R.id.et_nome_exer_alter);
        descricaoExer = (EditText)findViewById(R.id.et_descricao_exer_alter);
        statusExer = (EditText)findViewById(R.id.et_status_exer_alter);


        alterar = (Button)findViewById(R.id.btn_alter_exer);
        cursor = crud.carregaExerById(Integer.parseInt(codigo));

        nomeExer.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.NOME_EXER)));
        descricaoExer.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.DESCRICAO_EXER)));
        statusExer.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.STATUS_EXER)));


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                crud.alterarExercicio(Integer.parseInt(codigo), nomeExer.getText().toString(),descricaoExer.getText().toString(),statusExer.getText().toString());
                Toast.makeText(getBaseContext(), "Registro alterado com sucesso", Toast.LENGTH_LONG).show();
                Intent it = new Intent(MainActivityExercicioAlter.this, MainActivityDashBoard.class);
                startActivity(it);
                finish();
            }
        });

    }
}
