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
import br.com.ygorjs.acadsystem.Repositorio.RepoUsuario;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityUsuarioAlter extends AppCompatActivity{

    EditText nomeUsur;
    EditText tipoUsur;
    EditText sexo;
    EditText endereco;
    EditText bairro;
    EditText cidade;
    EditText estado;
    EditText status;
    EditText login;
    EditText senha;

    Button alterar;
    Cursor cursor;
    RepoUsuario crud;
    String codigo;

    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.content_main_usuario_alter);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new RepoUsuario(getBaseContext());

        nomeUsur = (EditText)findViewById(R.id.et_nome_usur_alter);
        tipoUsur = (EditText)findViewById(R.id.et_tipo_usur_alter);
        sexo = (EditText)findViewById(R.id.et_sexo_usur_alter);
        endereco = (EditText)findViewById(R.id.et_endereco_usur_alter);
        bairro = (EditText)findViewById(R.id.et_bairro_usur_alter);
        cidade = (EditText)findViewById(R.id.et_cidade_usur_alter);
        estado = (EditText)findViewById(R.id.et_estado_usur_alter);
        status = (EditText)findViewById(R.id.et_status_usur_alter);
        login = (EditText)findViewById(R.id.et_login_usur_alter);
        senha = (EditText)findViewById(R.id.et_senha_usur_alter);

        alterar = (Button)findViewById(R.id.btn_alter_Usur);


        cursor = crud.carregaUsurById(Integer.parseInt(codigo));
        nomeUsur.setText(cursor.getColumnIndexOrThrow(Conexao.NOME_USUR));
        tipoUsur.setText(cursor.getColumnIndexOrThrow(Conexao.TIPO_USUR));
        sexo.setText(cursor.getColumnIndexOrThrow(Conexao.SEXO_USUR));
        endereco.setText(cursor.getColumnIndexOrThrow(Conexao.ENDERECO_USUR));
        bairro.setText(cursor.getColumnIndexOrThrow(Conexao.BAIRRO_USUR));
        cidade.setText(cursor.getColumnIndexOrThrow(Conexao.CIDADE_USUR));
        estado.setText(cursor.getColumnIndexOrThrow(Conexao.ESTADO_USUR));
        status.setText(cursor.getColumnIndexOrThrow(Conexao.STATUS_USUR));
        login.setText(cursor.getColumnIndexOrThrow(Conexao.LOGIN_USUR));
        senha.setText(cursor.getColumnIndexOrThrow(Conexao.SENHA_USUR));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.alterarUsuario(Integer.parseInt(codigo),nomeUsur.getText().toString(),tipoUsur.getText().toString(),sexo.getText().toString(),endereco.getText().toString(),bairro.getText().toString(),cidade.getText().toString(),estado.getText().toString(),status.getText().toString(),login.getText().toString(),senha.getText().toString());
                Toast.makeText(getBaseContext(), "Registro alterado com sucesso", Toast.LENGTH_LONG).show();
                Intent it = new Intent(MainActivityUsuarioAlter.this, MainActivityDashBoard.class);
                startActivity(it);
                finish();


            }
        });





    }


}
