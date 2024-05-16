package com.example.paginalogin.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paginalogin.R;
import com.example.paginalogin.model.Produto;
import com.example.paginalogin.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("LugaLuga");
        setSupportActionBar(myToolbar);

        recyclerView = findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                                intent.putExtra("produto", produtoList.get(position));
                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), produtoList.get(position).getNome() , Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }

                        }));
    }

    public void CriarListaProdutos() {
        Produto produto = new Produto(
                "Iphone 14", "Iphone 14 128 gb BRANCO", "10", "4000.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "Iphone 13", "Iphone 13 64 gb PRETO", "12", "3600.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "Iphone 12", "Iphone 12 128 gb AZUL", "10", "3300.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "AirPods", "AirPods 3a geração", "8", "1918.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "AirPods Max", "AirPods Max PRATEADO", "9", "5500.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "Apple-Watch SE", "Apple-Watch SE DOURADO", "10", "2520.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "Apple-Watch Series 9", "Apple-Watch Series 9 ROSA", "9", "2700.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "iPad Pro 12,9 polegadas", "iPad Pro 12,9 6 Geração 2.000 GB Memória Interna ", "5", "21340.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "iPad Pro 11 polegadas", "iPad Pro 11 4 Geração 128 GB Memória Interna ", "7", "7999.00"
        );
        produtoList.add(produto);

        produto = new Produto(
                "MacBook Pro (2023)", "MacBook Pro (2023) HD de 8 TB ° 36 GB de RAM ", "5", "33000.00"
        );
        produtoList.add(produto);
    }

}