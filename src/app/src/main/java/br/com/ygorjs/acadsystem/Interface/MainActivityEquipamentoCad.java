package br.com.ygorjs.acadsystem.Interface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ygorjs.acadsystem.Controlador.ControladorEquipamento;
import br.com.ygorjs.acadsystem.Controlador.ControladorExercicio;
import br.com.ygorjs.acadsystem.R;

/**
 * Created by ygorjohassonsilva on 23/11/2015.
 */
public class MainActivityEquipamentoCad extends AppCompatActivity {

    private ControladorEquipamento crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_equipamento_cad);

        crud = new ControladorEquipamento();

        Button botao = (Button)findViewById(R.id.button_Cad_Equip);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome_Equip = (EditText)findViewById(R.id.et_nome_equip);
                EditText descricao_Equip = (EditText)findViewById(R.id.et_descricao_equip);
                EditText status_Equip = (EditText) findViewById(R.id.et_status_equip);
                EditText marca_Equip = (EditText) findViewById(R.id.et_marca_equip);

                crud.inserirEquipamento(nome_Equip,descricao_Equip,status_Equip,marca_Equip,getBaseContext());

            }
        });

    }
}