package br.unigran.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.unigran.appcadastro.BancoDados.DBHelper;

public class MainActivity extends AppCompatActivity {
        Button cliente;
        Button produto;
        Button fornecedor;
        Button sair;
        Intent intent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            cliente = findViewById(R.id.id_cliente);
            produto = findViewById(R.id.id_produto);
            fornecedor = findViewById(R.id.id_fornecedor);
            sair = findViewById(R.id.id_sair);
            DBHelper db = new DBHelper(MainActivity.this);
            acoesComponentes();
    }


    private void acoesComponentes() {
        produto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("operacao", 0);

                startActivity(intent);
            }
        });

        fornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("operacao", 1);

                startActivity(intent);
            }
        });

        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("operacao", 2);

                startActivity(intent);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}

