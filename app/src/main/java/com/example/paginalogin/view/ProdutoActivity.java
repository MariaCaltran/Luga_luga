package com.example.paginalogin.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.paginalogin.R;
import com.example.paginalogin.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.prod_alt);
        qtdProduto = findViewById(R.id.qtd_alt);
        precoProduto = findViewById(R.id.preco_alt);
        descProduto = findViewById(R.id.descricao_alt);


        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(produto.getQuantidade());
        precoProduto.setText(produto.getValor());
        descProduto.setText(produto.getDescricao());
        };
    }