package br.com.ygorjs.acadsystem.Interface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ygorjs.acadsystem.Controlador.ControladorExercicio;
import br.com.ygorjs.acadsystem.Controlador.ControladorUsuario;
import br.com.ygorjs.acadsystem.R;

/**
 * Created by ygorjohassonsilva on 23/11/2015.
 */
public class MainActivityUsuarioCad extends AppCompatActivity {

    private ControladorUsuario crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_usuario_cad);

        Button botao = (Button) findViewById(R.id.button_Cad_Usur);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud = new ControladorUsuario();

                EditText nome = (EditText)findViewById(R.id.et_nome_usur);
                EditText tipo_Usur = (EditText)findViewById(R.id.et_tipo_usur);
                EditText sexo = (EditText)findViewById(R.id.et_sexo_usur);
                EditText endereco = (EditText)findViewById(R.id.et_endereco_usur);
                EditText bairro = (EditText) findViewById(R.id.et_bairro_usur);
                EditText cidade = (EditText) findViewById(R.id.et_cidade_usur);
                EditText estado = (EditText) findViewById(R.id.et_estado_usur);
                EditText status = (EditText) findViewById(R.id.et_status_usur);
                EditText login = (EditText) findViewById(R.id.et_login_usur);
                EditText senha = (EditText)findViewById(R.id.et_senha_usur);


                crud.inserirUsuario(nome,tipo_Usur,sexo,endereco,bairro,cidade,estado,status,login,senha,getBaseContext());
            }
        });

    }

}