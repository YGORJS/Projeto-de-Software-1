package br.com.ygorjs.acadsystem.Interface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
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


    private static final String[] USUARIOS = new String[] {
            "João", "José", "Ygor", "Maria", "Antônio","Francisco","Jarley Nobrega","Bruna","Bruno","Joana","Marcos Alberto","Eduardo Calabria","Carlos Eduardo","Lara Dantas","Vitor","Ivna Valença"
    };

    private static final String[] EXERCICIOS = new String[]{
            "Exer1","Musculação","Marinheiro","Abdominal","Exer2","Exer3","Exer4","Exer5","Elevação de pernas","Frontal","Rosca inversa","Rosca martelo"
    };

    private static final String[]EQUIPAMENTOS = new String[]{
            "Equip1","Bicicleta","Esteira","Equip2","Equip3","Equip4","Equip5","Leg Press","Supino Reto","Puxador costas"
    };

    public void clientes(String [] USUARIOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,USUARIOS);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.atc_usur_alter);
        textView.setAdapter(adapter);

    }
    public void exercicios(String [] EXERCICIOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, EXERCICIOS);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.atc_exer_alter);
        textView.setAdapter(adapter);

    }

    public void equipamentos(String [] EQUIPAMENTOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, EQUIPAMENTOS);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.atc_equip_alter);
        textView.setAdapter(adapter);

    }

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setContentView(R.layout.content_main_associacao_alter);

        clientes(USUARIOS);
        exercicios(EXERCICIOS);
        equipamentos(EQUIPAMENTOS);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new RepoAssociacao(getBaseContext());


        nomeEquipAss  = (AutoCompleteTextView)findViewById(R.id.atc_equip_alter);
        nomeExerAssoc = (AutoCompleteTextView)findViewById(R.id.atc_exer_alter);
        nomeUsurAssoc = (AutoCompleteTextView)findViewById(R.id.atc_usur_alter);





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
