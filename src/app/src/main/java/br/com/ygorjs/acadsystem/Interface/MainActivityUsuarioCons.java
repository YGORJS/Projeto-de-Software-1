package br.com.ygorjs.acadsystem.Interface;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.R;
import br.com.ygorjs.acadsystem.Repositorio.RepoUsuario;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityUsuarioCons extends AppCompatActivity {

    private ListView lista;
    private Cursor cursor;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.content_main_usuario_cons);


        RepoUsuario crud = new RepoUsuario(getBaseContext());

        cursor = crud.mostrarUsuario();

        String[] nomeCampos = new String[]{

            Conexao.ID_USUR,
            Conexao.NOME_USUR,
            Conexao.TIPO_USUR,
            Conexao.SEXO_USUR,
            Conexao.ENDERECO_USUR,
            Conexao.BAIRRO_USUR,
            Conexao.CIDADE_USUR,
            Conexao.ESTADO_USUR,
            Conexao.STATUS_USUR,
            Conexao.LOGIN_USUR,
            Conexao.SENHA_USUR
        };
        int [] idViews = new int[]{

                R.id.tv_id_usur_cons,
                R.id.tv_nome_usur_cons,
                R.id.tv_tipo_usur_cons,
                R.id.tv_sexo_usur_cons,
                R.id.tv_endereco_usur_cons,
                R.id.tv_bairro_usur_cons,
                R.id.tv_cidade_usur_cons,
                R.id.tv_estado_usur_cons,
                R.id.tv_status_usur_cons,
                R.id.tv_login_usur_cons,
                R.id.tv_senha_usur_cons
        };



        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.layout_cons_usuario,cursor,nomeCampos,idViews,0);
        lista = (ListView) findViewById(R.id.listViewConsUsur);
        lista.setAdapter(adapter);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(Conexao.ID_USUR));
                Intent intent = new Intent(MainActivityUsuarioCons.this, MainActivityUsuarioAlter.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();

            }

        });




    }
}
