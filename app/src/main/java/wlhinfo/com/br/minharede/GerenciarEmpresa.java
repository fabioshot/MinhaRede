package wlhinfo.com.br.minharede;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import wlhinfo.com.br.minharede.dao.DaoEmpresa;
import wlhinfo.com.br.minharede.model.Empresa;

public class GerenciarEmpresa extends AppCompatActivity {

    Empresa empresa = new Empresa();
    EditText nome;
    EditText gateway;
    RadioButton classeA;
    RadioButton classeB;
    RadioButton classeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_empresa);

        nome = (EditText) findViewById(R.id.etNome);
        gateway = (EditText) findViewById(R.id.etGateway);
        classeA = (RadioButton) findViewById(R.id.rbClasseA);
        classeB = (RadioButton) findViewById(R.id.rbClasseB);
        classeC = (RadioButton) findViewById(R.id.rbClasseC);

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null && bundle.containsKey("codigo")){
            Integer codigo = bundle.getInt("codigo");
            empresa =  new DaoEmpresa(this).consultarPorEmpresa(codigo);
            nome.setText(empresa.getNome());
            gateway.setText(empresa.getGateway());

            if (empresa.getMascara().equals("255.0.0.0")){
                classeA.setChecked(true);
            }
            else if (empresa.getMascara().equals("255.255.0.0")){
                classeB.setChecked(true);
            }
            else if (empresa.getMascara().equals("255.255.255.0")){
                classeC.setChecked(true);
            }
        }


    }

    public void salvar(View view){
        empresa.setNome(nome.getText().toString());
        empresa.setGateway(gateway.getText().toString());
        if(classeA.isChecked()){
            empresa.setMascara("255.0.0.0");
        }
        else if(classeB.isChecked()){
            empresa.setMascara("255.255.0.0");
        }
        else if (classeC.isChecked()){
            empresa.setMascara("255.255.255.0");
        }
        if (empresa.getCodigo()==null){
            new DaoEmpresa(this).inserir(empresa);
        }
        else
            new DaoEmpresa(this).alterar(empresa);

        finish();
    }
}
