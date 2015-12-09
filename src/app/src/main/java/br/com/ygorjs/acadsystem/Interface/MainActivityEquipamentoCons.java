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
import br.com.ygorjs.acadsystem.Repositorio.RepoEquipamento;

/**
 * Created by ygorjohassonsilva on 08/12/2015.
 */
public class MainActivityEquipamentoCons extends AppCompatActivity {

    private ListView lista;
    private Cursor cursor;



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);

        setContentView(R.layout.content_main_equipamento_cons);

        RepoEquipamento crud = new RepoEquipamento(getBaseContext());
        cursor = crud.mostrarEquipamento();

        String nomeCampos[] = new String[] {

                Conexao.ID_EQUIP,
                Conexao.NOME_EQUIP,
                Conexao.DESCRICAO_EQUIP,
                Conexao.STATUS_EQUIP,
                Conexao.MARCA_EQUIP
        };

        int [] idViews = new int[]{

                R.id.tv_id_equip_cons,
                R.id.tv_nome_equip_cons,
                R.id.tv_descricao_equip_cons,
                R.id.tv_status_equip_cons,
                R.id.tv_marca_equip_cons

        };


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.layout_cons_equipamento,cursor,nomeCampos,idViews,0);
        lista = (ListView) findViewById(R.id.listViewConsEquip);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(Conexao.ID_EQUIP));
                Intent intent = new Intent(MainActivityEquipamentoCons.this, MainActivityEquipamentoAlter.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();

            }

        });
    }
}
