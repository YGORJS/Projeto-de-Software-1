package br.com.ygorjs.acadsystem.Interface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.Conexao.Conexao;
import br.com.ygorjs.acadsystem.R;
import br.com.ygorjs.acadsystem.Repositorio.RepoAssociacao;

/**
 * Created by ygorjohassonsilva on 02/12/2015.
 */
public class MainActivityAssociacaoAlter extends AppCompatActivity{

    AutoCompleteTextView nomeUsurAssoc;
    AutoCompleteTextView nomeExerAssoc;
    AutoCompleteTextView nomeEquipAss;
    Button alterar;
    Cursor cursor;
    RepoAssociacao crud;
    String codigo;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setContentView(R.layout.content_main_associacao_alter);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new RepoAssociacao(getBaseContext());

        nomeEquipAss  = (AutoCompleteTextView)findViewById(R.id.atc_equip);
        nomeExerAssoc = (AutoCompleteTextView)findViewById(R.id.atc_exer);
        nomeUsurAssoc = (AutoCompleteTextView)findViewById(R.id.atc_usur);

        alterar = (Button)findViewById(R.id.btnAlterar);

        cursor = crud.carregaAssocById(Integer.parseInt(codigo));
        nomeEquipAss.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.NOME_EQUIP_ASSOC)));
        nomeExerAssoc.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.NOME_EXER_ASSOC)));
        nomeUsurAssoc.setText(cursor.getString(cursor.getColumnIndexOrThrow(Conexao.NOME_USUR_ASSOC)));


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MainActivityAssociacaoCad.camposRequired(nomeUsurAssoc,nomeExerAssoc,nomeEquipAss)){
                    crud.alterarAssociacao(Integer.parseInt(codigo), nomeUsurAssoc.getText().toString(), nomeExerAssoc.getText().toString(), nomeEquipAss.getText().toString());
                    Toast.makeText(getBaseContext(),"Registro alterado com sucesso",Toast.LENGTH_LONG).show();
                    Intent it = new Intent(MainActivityAssociacaoAlter.this, MainActivityDashBoard.class);
                    startActivity(it);
                    finish();

                }else{

                    Toast.makeText(getBaseContext(),"Todos os dados são obrigatórios",Toast.LENGTH_LONG).show();
                }

            }
        });

    }


}
