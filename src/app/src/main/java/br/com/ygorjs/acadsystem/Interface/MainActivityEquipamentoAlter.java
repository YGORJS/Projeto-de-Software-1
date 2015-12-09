package br.com.ygorjs.acadsystem.Interface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.R;
import br.com.ygorjs.acadsystem.Repositorio.RepoEquipamento;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityEquipamentoAlter extends AppCompatActivity {


    private EditText nomeEquip;
    private EditText descricaoEquip;
    private EditText statusEquip;
    private EditText marcaEquip;

    private Button alterar;
    private Cursor cursor;
    private RepoEquipamento crud;
    private String codigo;

    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.content_main_equipamento_alter);

        codigo = getIntent().getStringExtra("codigo");
        crud = new RepoEquipamento(getBaseContext());


        nomeEquip = (EditText)findViewById(R.id.et_nome_equip_alter);
        descricaoEquip = (EditText)findViewById(R.id.et_descricao_equip_alter);
        statusEquip = (EditText)findViewById(R.id.et_status_equip_alter);
        marcaEquip = (EditText)findViewById(R.id.et_marca_equip_alter);

        alterar = (Button)findViewById(R.id.btn_Alter_Equip);
        cursor = crud.carregaEquipById(Integer.parseInt(codigo));

        nomeEquip.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.NOME_EQUIP)));
        descricaoEquip.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.DESCRICAO_EQUIP)));
        statusEquip.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.STATUS_EQUIP)));
        marcaEquip.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.MARCA_EQUIP)));


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.alterarEquipamento(Integer.parseInt(codigo),nomeEquip.getText().toString(),descricaoEquip.getText().toString(),statusEquip.getText().toString(),marcaEquip.getText().toString());
                Toast.makeText(getBaseContext(), "Registro alterado com sucesso", Toast.LENGTH_LONG).show();
                Intent it = new Intent(MainActivityEquipamentoAlter.this, MainActivityDashBoard.class);
                startActivity(it);
                finish();

            }
        });









    }
}
