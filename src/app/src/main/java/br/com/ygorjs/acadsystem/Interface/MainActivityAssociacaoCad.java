package br.com.ygorjs.acadsystem.Interface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PortUnreachableException;

import br.com.ygorjs.acadsystem.Controlador.ControladorAssociacao;
import br.com.ygorjs.acadsystem.R;

/**
 * Created by ygorjohassonsilva on 25/11/2015.
 */
public class MainActivityAssociacaoCad extends AppCompatActivity {

    ControladorAssociacao crud = new ControladorAssociacao();

    private static final String[] USUARIOS = new String[] {
            "João", "José", "Ygor", "Maria", "Antônio","Francisco","Jarley Nobrega","Bruna","Bruno","Joana"
    };

    private static final String[] EXERCICIOS = new String[]{
            "Exer1","Musculação","Marinheiro","Abdôminal","Exer2","Exer3","Exer4","Exer5"
    };

    private static final String[]EQUIPAMENTOS = new String[]{
            "Equip1","Bicicleta","Esteira","Equip2","Equip3","Equip4","Equip5"
    };
/////////////////////////////////////////////////////////////
    protected void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        setContentView(R.layout.content_main_associacao_cad);



        clientes(USUARIOS);
        exercicios(EXERCICIOS);
        equipamentos(EQUIPAMENTOS);

        Button botao = (Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cliente = (EditText)findViewById(R.id.atc_usur);
                EditText exercicio = (EditText)findViewById(R.id.atc_exer);
                EditText equipamento = (EditText)findViewById(R.id.atc_equip);

                if(camposRequired(cliente,exercicio,equipamento)) {
                    crud.incluirAssociacao(cliente, exercicio, equipamento, getBaseContext());
                }else {
                    Toast.makeText(getBaseContext(),"Todos os dados são obrigatorios",Toast.LENGTH_LONG).show();

                }

            }
        });

    }

///////////////////////////////////////////////////////////////


    public void clientes(String [] USUARIOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,USUARIOS);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.atc_usur);
        textView.setAdapter(adapter);

    }

    public static boolean camposRequired(EditText nomeUsurAssc, EditText nomeEquipAssoc, EditText nomeExerAssoc){

        if(!nomeUsurAssc.getText().toString().equals("") && !nomeEquipAssoc.getText().toString().equals("") && !nomeExerAssoc.getText().toString().equals("")){

            return true;

        }else{

            return false;

        }
    }



    public void exercicios(String [] EXERCICIOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, EXERCICIOS);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.atc_exer);
        textView.setAdapter(adapter);

    }

    public void equipamentos(String [] EQUIPAMENTOS){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, EQUIPAMENTOS);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.atc_equip);
        textView.setAdapter(adapter);

    }
}
