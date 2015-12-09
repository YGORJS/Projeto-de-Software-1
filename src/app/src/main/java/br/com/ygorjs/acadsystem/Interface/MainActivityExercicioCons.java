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
import br.com.ygorjs.acadsystem.Repositorio.RepoExercicio;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityExercicioCons extends AppCompatActivity {


    private ListView lista;
    private Cursor cursor;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    protected void onCreate(Bundle savadInstanceBundle){

        super.onCreate(savadInstanceBundle);

        setContentView(R.layout.content_main_exercicio_cons);

        RepoExercicio crud = new RepoExercicio(getBaseContext());


        cursor = crud.mostrarExercicio();

        String[] nomeCampos = new String[]{

                Conexao.ID_EXER,
                Conexao.NOME_EXER,
                Conexao.DESCRICAO_EXER,
                Conexao.STATUS_EXER

        };
        int [] idViews = new int[]{

                R.id.tv_id_exer_cons,
                R.id.tv_nome_exer_cons,
                R.id.tv_descricao_exer_cons,
                R.id.tv_status_exer_cons

        };



        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.layout_cons_exercicio,cursor,nomeCampos,idViews,0);
        lista = (ListView) findViewById(R.id.listViewConsExer);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(Conexao.ID_EXER));
                Intent intent = new Intent(MainActivityExercicioCons.this, MainActivityExercicioAlter.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();

            }

        });

    }
}
