package wlhinfo.com.br.minharede.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import wlhinfo.com.br.minharede.model.Empresa;

/**
 * Created by aluno on 11/05/18.
 */

public class DaoEmpresa {

    private SQLiteDatabase databese;

    public DaoEmpresa(Context contexto){
        databese = new BDcore(contexto).getWritableDatabase();
    }

    public void inserir(Empresa empresa){
        ContentValues values = new ContentValues();
        values.put("nome", empresa.getNome());
        values.put("gateway", empresa.getGateway());
        values.put("mascara", empresa.getMascara() );

        databese.insert("empresa", null, values);
    }

    public void alterar(Empresa empresa){
        ContentValues values = new ContentValues();
        values.put("nome", empresa.getNome());
        values.put("gateway", empresa.getGateway());
        values.put("mascara", empresa.getMascara() );

        databese.update("empresa", values, "codigo="+empresa.getCodigo(), null);
    }

    public void excluir(Integer codigo){
        databese.delete("empresa", "codigo=?", new String[]{String.valueOf(codigo)});
    }

    public List<Empresa> consultar(){
        List<Empresa> empresas = new ArrayList<>();
        String[] colunas = {"codigo","nome","gateway","mascara"};
        Cursor cursor = databese.query("empresa", colunas, null, null, null, null, null);

        cursor.moveToFirst();

        for(int x=0; x<cursor.getCount(); x++){
            Empresa empresa = new Empresa();
            empresa.setCodigo(cursor.getInt(0));
            empresa.setNome(cursor.getString(1));
            empresa.setGateway(cursor.getString(2));
            empresa.setMascara(cursor.getString(3));
            empresas.add(empresa);

            cursor.moveToNext();
        }

        return empresas;
    }

    public Empresa consultarPorEmpresa(Integer codigo){
        String[] colunas = {"codigo","nome","gateway","mascara"};
        Cursor cursor = databese.query("empresa", colunas, "codigo="+codigo, null, null, null, null);

        cursor.moveToFirst();

            Empresa empresa = new Empresa();
            empresa.setCodigo(cursor.getInt(0));
            empresa.setNome(cursor.getString(1));
            empresa.setGateway(cursor.getString(2));
            empresa.setMascara(cursor.getString(3));


        return empresa;
    }

}
