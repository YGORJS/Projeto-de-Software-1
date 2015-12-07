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
import br.com.ygorjs.acadsystem.Repositorio.RepoAssociacao;

/**
 * Created by ygorjohassonsilva on 29/11/2015.
 */
public class MainActivityAssociacaoCons extends AppCompatActivity{

    private ListView lista;
    private Cursor cursor;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.content_main_associacao_cons);



        RepoAssociacao crud = new RepoAssociacao(getBaseContext());

        cursor = crud.mostrarAssociacao();
        String[] nomeCampos = new String[]{

                Conexao.ID_ASSOC,
                Conexao.NOME_EQUIP_ASSOC,
                Conexao.NOME_EXER_ASSOC,
                Conexao.NOME_USUR_ASSOC
        };
        int [] idViews = new int[]{
                R.id.idAssoc,
                R.id.nomeEquipAssoc,
                R.id.nomeExerAssoc,
                R.id.nomeUsurAssoc
        };


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.layout_cons_associacao,cursor,nomeCampos,idViews,0);
        lista = (ListView) findViewById(R.id.listViewConsAssoc);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){

                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(Conexao.ID_ASSOC));
                Intent intent = new Intent(MainActivityAssociacaoCons.this,MainActivityAssociacaoAlter.class);
                intent.putExtra("codigo",codigo);
                startActivity(intent);
                finish();

            }

        });


    }

}
