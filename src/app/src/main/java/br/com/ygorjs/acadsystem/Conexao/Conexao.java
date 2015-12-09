package br.com.ygorjs.acadsystem.Conexao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ygorjohassonsilva on 22/11/2015.
 */
public class Conexao extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "AcadSystem.db";

    public static final String TAB_EXER = "Exercicio";
    public static final String ID_EXER = "_id";
    public static final String NOME_EXER = "nome";
    public static final String DESCRICAO_EXER = "descricao";
    public static final String STATUS_EXER = "status";

    public static final String TAB_USUR = "Usuario";
    public static final String ID_USUR = "_id";
    public static final String NOME_USUR ="nome_usur";
    public static final String TIPO_USUR = "tipo_usur";
    public static final String SEXO_USUR = "sexo_usur";
    public static final String ENDERECO_USUR = "endereco_usur";
    public static final String BAIRRO_USUR ="bairro_usur";
    public static final String CIDADE_USUR = "cidade_usur";
    public static final String ESTADO_USUR = "estado_usur";
    public static final String STATUS_USUR = "status_usur";
    public static final String LOGIN_USUR = "login_usur";
    public static final String SENHA_USUR = "senha_usur";
    //ainda falta inserir os campos de data



    public static final String TAB_EQUIP = "Equipamento";
    public static final String ID_EQUIP = "_id";
    public static final String NOME_EQUIP = "nome_equip";
    public static final String DESCRICAO_EQUIP = "descricao_equip";
    public static final String STATUS_EQUIP = "status_equip";
    public static final String MARCA_EQUIP = "marca_equip";


    public static final String TAB_ASSC = "Associacao";
    public static final String ID_ASSOC="_id";
    public static final String NOME_USUR_ASSOC="nome_usur_assoc";
    public static final String NOME_EXER_ASSOC="nome_exer_assoc";
    public static final String NOME_EQUIP_ASSOC="nome_equip_assoc";


    public static final int VERSION = 6;

    public Conexao(Context context) {
        super(context, NOME_BANCO, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        //criando tabela  de exercicios
        String sql = "CREATE TABLE "+ TAB_EXER +" ( "
                + ID_EXER +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME_EXER +" TEXT, "
                + DESCRICAO_EXER +" TEXT, "
                + STATUS_EXER +" TEXT )";

        db.execSQL(sql);

        String sql1= "CREATE TABLE "+TAB_USUR+" ( "
                +ID_USUR+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NOME_USUR+" TEXT, "
                +TIPO_USUR+" TEXT, "
                +SEXO_USUR+" TEXT, "
                +ENDERECO_USUR+" TEXT,"
                +BAIRRO_USUR+" TEXT,"
                +CIDADE_USUR+" TEXT,"
                +ESTADO_USUR+" TEXT,"
                +STATUS_USUR+" TEXT,"
                +LOGIN_USUR+" TEXT,"
                +SENHA_USUR+" TEXT )";

        db.execSQL(sql1);



        //criando tabela de equipamento
        String sql2 = "CREATE TABLE "+TAB_EQUIP+" ( "
                +ID_EQUIP+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NOME_EQUIP+" TEXT, "
                +DESCRICAO_EQUIP+" TEXT, "
                +STATUS_EQUIP+" TEXT, "
                +MARCA_EQUIP+" TEXT )";

        db.execSQL(sql2);



        //criando tabela de associação
        String sql3 = "CREATE TABLE "+TAB_ASSC+" ( "
                +ID_ASSOC+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NOME_EQUIP_ASSOC+" TEXT, "
                +NOME_EXER_ASSOC+" TEXT, "
                +NOME_USUR_ASSOC+" TEXT )";

        db.execSQL(sql3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS  "+this.TAB_EXER);
        db.execSQL("DROP TABLE IF EXISTS  "+this.TAB_EQUIP);
        db.execSQL("DROP TABLE IF EXISTS  "+this.TAB_USUR);
        db.execSQL("DROP TABLE IF EXISTS  "+this.TAB_ASSC);

        this.onCreate(db);

    }
}