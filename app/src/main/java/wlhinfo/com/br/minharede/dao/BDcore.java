package wlhinfo.com.br.minharede.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aluno on 20/04/18.
 */

public class BDcore extends SQLiteOpenHelper {

    //final para os valores não mudarem

    private final static String NOME_BANCO = "redeip"; //Nome do banco de dados
    private final static Integer VERSAO_BANCO = 2 ; //Versão do banco de dados

    public BDcore(Context contexto){
        super(contexto, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // todas as tabelas do banco é criado nesse metodo.
       db.execSQL("create table empresa(codigo integer primary key autoincrement, " +
               "nome varchar(200)," +
               "gateway vachar(15)," +
               "mascara varchar(15));"); // criando table do banco de dados;

        db.execSQL("create table endereco(codigo integer primary key autoincrement, " +
                "ip varchar(15)," +
                "equipamento vachar(50)," +
                "codempresa integer," +
                "foreign key (codempresa) references empresa(codigo));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //usado para atulizar o banco de dados em caso de mudança de versao, recriando novamente a tabela;
        db.execSQL("drop table empresa");
        db.execSQL("drop table endereco");
        onCreate(db);
    }
}
