package br.unigran.appcadastro.BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.appcadastro.Entidades.Produto;

public class ProdutoDB {
    private DBHelper db;
    private SQLiteDatabase conexao;

    public ProdutoDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Produto produto) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", produto.getNome());
        values.put("marca", produto.getMarca());
        values.put("quantidade", produto.getQuantidade());
        values.put("dataValidade", produto.getDataValidade());
        values.put("preco", produto.getPreco());

        conexao.insertOrThrow("produtos", null, values);

        conexao.close();
    }

    public void listar(List<Produto> listaProdutos) {
        listaProdutos.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nome", "marca", "quantidade", "dataValidade", "preco"};
        Cursor query = conexao.query("produtos", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Produto produtos = new Produto();

            produtos.setId(query.getInt(0));
            produtos.setNome(query.getString(1));
            produtos.setMarca(query.getString(2));
            produtos.setQuantidade(query.getInt(3));
            produtos.setDataValidade(query.getString(4));
            produtos.setPreco(query.getFloat(5));

            listaProdutos.add(produtos);
        }

        conexao.close();
    }
}
