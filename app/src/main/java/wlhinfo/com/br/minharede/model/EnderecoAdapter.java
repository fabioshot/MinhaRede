package wlhinfo.com.br.minharede.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import wlhinfo.com.br.minharede.R;

/**
 * Created by aluno on 11/05/18.
 */

public class EnderecoAdapter extends BaseAdapter {

    List<Endereco> listaEndereco;
    Context contexto;

    public EnderecoAdapter(List<Endereco> listaEndereco, Context contexto){
        this.listaEndereco = listaEndereco;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listaEndereco.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEndereco.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaEndereco.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewEndereco = LayoutInflater.from(contexto).inflate(R.layout.lista_endereco_model, parent, false);

        TextView ip = (TextView) viewEndereco.findViewById(R.id.tvIp);
        TextView equipamento = (TextView) viewEndereco.findViewById(R.id.tvEquipamento);

        Endereco endereco = listaEndereco.get(position);

        ip.setText(endereco.getIp());
        equipamento.setText(endereco.getEquipamento());

        return viewEndereco;
    }
}
