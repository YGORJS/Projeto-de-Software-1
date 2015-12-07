package br.com.ygorjs.acadsystem.Interface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.ygorjs.acadsystem.R;

/**
 * Created by ygorjohassonsilva on 28/11/2015.
 */
public class MainActivityDashBoard extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceBunde){
        super.onCreate(savedInstanceBunde);

        setContentView(R.layout.content_main_dash_board);

    }



    public void selecionarOpcao(View view){

        TextView textView  = (TextView) view;
        String opcao = "Opção : "+textView.getText().toString();
        displayToast(opcao);

        instanceActivity(textView.getText().toString());

    }

    public void displayToast(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }

    public void instanceActivity(String opcao){

        switch (opcao){

            case  "Novo Usuário":

                Intent itUsurCad = new Intent(this,MainActivityUsuarioCad.class);
                startActivity(itUsurCad);
                break;

            case "Novo Equipamento":

                Intent itEquipCad = new Intent(this,MainActivityEquipamentoCad.class);
                startActivity(itEquipCad);
                break;

            case "Novo Exercício":

                Intent itExercCad = new Intent(this,MainActivityExercicioCad.class);
                startActivity(itExercCad);
                break;

            case "Nova Associação":

                Intent itAsscCad = new Intent(this,MainActivityAssociacaoCad.class);
                startActivity(itAsscCad);
                break;

            case "Consultar Associações":

                startActivity(new Intent(this,MainActivityAssociacaoCons.class));
                break;
        }
    }

}
