package br.com.ygorjs.acadsystem.Controlador;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Modelo.ModeloUsuario;
import br.com.ygorjs.acadsystem.Repositorio.RepoExercicio;
import br.com.ygorjs.acadsystem.Repositorio.RepoUsuario;

/**
 * Created by ygorjohassonsilva on 24/11/2015.
 */
public class ControladorUsuario {

    private String resultado = "";
    private RepoUsuario crud ;


    public void inserirUsuario(EditText nome, EditText tipo_Usur, EditText sexo,EditText endereco, EditText bairro, EditText cidade, EditText estado, EditText status, EditText login, EditText senha, Context context){


        crud = new RepoUsuario(context.getApplicationContext());

        String nomeI = nome.getText().toString();
        String tipo_UsurI = tipo_Usur.getText().toString();
        String sexoI = sexo.getText().toString();
        String enderecoI = endereco.getText().toString();
        String bairroI = bairro.getText().toString();
        String cidadeI = cidade.getText().toString();
        String estadoI= estado.getText().toString();
        String statusI = status.getText().toString();
        String loginI = login.getText().toString();
        String senhaI = senha.getText().toString();


        this.resultado = crud.incluirUsuario(nomeI,tipo_UsurI,sexoI,enderecoI,bairroI,cidadeI,estadoI,statusI,loginI,senhaI);
        Toast.makeText(context.getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

        this.fieldEmpty(nome,tipo_Usur,sexo,endereco,bairro,cidade,estado,status,login,senha);

    }

    private void fieldEmpty(EditText nome, EditText tipoUsur,EditText sexo,EditText endereco, EditText bairro, EditText cidade, EditText estado, EditText status, EditText login , EditText senha ){


        nome.setText("");
        tipoUsur.setText("");
        sexo.setText("");
        endereco.setText("");
        bairro.setText("");
        cidade.setText("");
        estado.setText("");
        status.setText("");
        login.setText("");
        senha.setText("");
    }

}
