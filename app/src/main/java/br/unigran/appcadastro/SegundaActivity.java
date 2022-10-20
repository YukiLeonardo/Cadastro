package br.unigran.appcadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.unigran.appcadastro.fragmentos.FragmentCliente;
import br.unigran.appcadastro.fragmentos.FragmentFornecedor;
import br.unigran.appcadastro.fragmentos.FragmentListCliente;
import br.unigran.appcadastro.fragmentos.FragmentListFornecedor;
import br.unigran.appcadastro.fragmentos.FragmentListProduto;
import br.unigran.appcadastro.fragmentos.FragmentProduto;

public class SegundaActivity extends AppCompatActivity {
    Button cadastrar;
    Button listar;
    Button voltar;

    Integer Operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        cadastrar = findViewById(R.id.id_cadastro);
        listar = findViewById(R.id.id_listagem);
        voltar = findViewById(R.id.id_voltar);
        Operacao = getIntent().getIntExtra("operacao", -1);


    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (Operacao){
        case -1:{
            onBackPressed();
            break;
        }

        case 0:{
            transaction.add(R.id.id_principal, new FragmentListProduto());
            break;
        }

        case 1:{
            transaction.add(R.id.id_principal,new FragmentListCliente());
            break;
        }

        case 2:{
            transaction.add(R.id.id_principal,new FragmentListFornecedor() );
            break;
        }
    }

        transaction.commit();
    acoesComponentes();
}

    private void acoesComponentes() {
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Operacao){
                    case 0:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_principal, new FragmentProduto()).commit();
                        break;
                    }
                    case 1:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_principal, new FragmentCliente()).commit();
                        break;
                    }
                    case 2:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.id_principal, new FragmentFornecedor()).commit();

                        break;
                    }
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}