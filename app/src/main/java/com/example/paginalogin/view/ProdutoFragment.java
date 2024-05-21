package com.example.paginalogin.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.paginalogin.R;
import com.example.paginalogin.model.Produto;
import com.example.paginalogin.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;
public class ProdutoFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProdutoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProdutoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdutoFragment newInstance(String param1, String param2) {
        ProdutoFragment fragment = new ProdutoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                                intent.putExtra("produto", produtoList.get(position));
                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getContext(), produtoList.get(position).getNome() , Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }

                        }));
        // Inflate the layout for this fragment
        return view;
    }
    public void CriarListaProdutos() {
        Produto produto = new Produto(
                "Iphone 14", "Iphone 14 128 gb BRANCO", "10", "4000.00"
        );
        produtoList.add(produto);

        Produto produto1 = new Produto(
                "Iphone 13", "Iphone 13 64 gb PRETO", "12", "3600.00"
        );
        produtoList.add(produto1);

        Produto produto2 = new Produto(
                "Iphone 12", "Iphone 12 128 gb AZUL", "10", "3300.00"
        );
        produtoList.add(produto2);

        Produto produto3 = new Produto(
                "AirPods", "AirPods 3a geração", "8", "1918.00"
        );
        produtoList.add(produto3);

        Produto produto4 = new Produto(
                "AirPods Max", "AirPods Max PRATEADO", "9", "5500.00"
        );
        produtoList.add(produto4);

        Produto produto5 = new Produto(
                "Apple-Watch SE", "Apple-Watch SE DOURADO", "10", "2520.00"
        );
        produtoList.add(produto5);

        Produto produto6 = new Produto(
                "Apple-Watch Series 9", "Apple-Watch Series 9 ROSA", "9", "2700.00"
        );
        produtoList.add(produto6);

        Produto produto7 = new Produto(
                "iPad Pro 12,9 polegadas", "iPad Pro 12,9 6 Geração 2.000 GB Memória Interna ", "5", "21340.00"
        );
        produtoList.add(produto7);

        Produto produto8 = new Produto(
                "iPad Pro 11 polegadas", "iPad Pro 11 4 Geração 128 GB Memória Interna ", "7", "7999.00"
        );
        produtoList.add(produto8);

        Produto produto9 = new Produto(
                "MacBook Pro (2023)", "MacBook Pro (2023) HD de 8 TB ° 36 GB de RAM ", "5", "33000.00"
        );
        produtoList.add(produto9);
    }
}