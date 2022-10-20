package br.unigran.appcadastro.BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.appcadastro.Entidades.Fornecedor;

public class FornecedorDB {
    private DBHelper db;
    private SQLiteDatabase conexao;

    public FornecedorDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Fornecedor fornecedor) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nomeFantasia", fornecedor.getNomeFornecedor());
        values.put("cnpj", fornecedor.getCNPJ());
        values.put("telefone", fornecedor.getTelefone());
        values.put("email", fornecedor.getEmail());

        conexao.insertOrThrow("fornecedores", null, values);
    }

    public void remover(Integer id) {
        conexao = db.getWritableDatabase();

        conexao.delete("fornecedores", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Fornecedor> listaFornecedores) {
        listaFornecedores.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nomeFantasia", "cnpj", "telefone", "email"};
        Cursor query = conexao.query("fornecedores", colunas, null, null, null, null, "nomeFantasia");

        while (query.moveToNext()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setId(query.getInt(0));
            fornecedor.setNomeFornecedor(query.getString(1));
            fornecedor.setCNPJ(query.getString(2));
            fornecedor.setTelefone(query.getString(3));
            fornecedor.setEmail(query.getString(4));

            listaFornecedores.add(fornecedor);
        }

        conexao.close();
    }
}
