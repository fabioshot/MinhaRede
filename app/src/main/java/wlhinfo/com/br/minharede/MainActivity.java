package wlhinfo.com.br.minharede;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import wlhinfo.com.br.minharede.dao.DaoEmpresa;
import wlhinfo.com.br.minharede.model.Empresa;
import wlhinfo.com.br.minharede.model.EmpresaAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    ListView listViewEmpresa;
    EmpresaAdapter empresaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewEmpresa = (ListView) findViewById(R.id.lvEmpresas);
        listViewEmpresa.setOnItemClickListener(this);
        listViewEmpresa.setOnItemLongClickListener(this);

    }

    public void adicionarEmpresa(View view){
        Intent intent = new Intent(this, GerenciarEmpresa.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Empresa> listaEmpresa = new ArrayList<>();
        listaEmpresa = new DaoEmpresa(this).consultar();
        listViewEmpresa = (ListView) findViewById(R.id.lvEmpresas);
        empresaAdapter = new EmpresaAdapter(listaEmpresa, this);
        listViewEmpresa.setAdapter(empresaAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, GerenciarEmpresa.class);
        intent.putExtra("codigo", Integer.parseInt(String.valueOf(id)));
        startActivity(intent);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new DaoEmpresa(this).excluir((int)id);

        List<Empresa> empresas = new DaoEmpresa(this).consultar();
        empresaAdapter = new EmpresaAdapter(empresas, this);
        listViewEmpresa.setAdapter(empresaAdapter);

        return true;
    }
}
