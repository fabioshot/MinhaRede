package wlhinfo.com.br.minharede.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.List;

import wlhinfo.com.br.minharede.R;
import wlhinfo.com.br.minharede.model.Empresa;

/**
 * Created by aluno on 11/05/18.
 */

public class EmpresaAdapter extends BaseAdapter {

    List<Empresa> listaEmpresa;
    Context contexto;

    public EmpresaAdapter(List<Empresa> listaEmpresa, Context contexto){
        this.contexto = contexto;
        this.listaEmpresa = listaEmpresa;
    }

    @Override
    public int getCount() {
        return listaEmpresa.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEmpresa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaEmpresa.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewEmpresa = LayoutInflater.from(contexto).inflate(R.layout.lista_empresa_model, parent, false);

        TextView nome = (TextView) viewEmpresa.findViewById(R.id.tvNome);
        TextView gateway = (TextView) viewEmpresa.findViewById(R.id.tvGateway);
        TextView mascara = (TextView) viewEmpresa.findViewById(R.id.tvMascara);

        Empresa empresa = listaEmpresa.get(position);

        nome.setText(empresa.getNome());
        gateway.setText(empresa.getGateway());
        mascara.setText(empresa.getMascara());

        return viewEmpresa;
    }
}
