package com.example.paginalogin.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paginalogin.R;
import com.example.paginalogin.model.Produto;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.ViewHolder> {

    private List<Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }


    @NonNull
    @Override
    public AdapterProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listaprodutos = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_produto, parent, false);

        return new ViewHolder(listaprodutos);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduto.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nome_TV, preco_tv, descricao_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nome_TV = itemView.findViewById(R.id.nome_TV);
            preco_tv = itemView.findViewById(R.id.preco_tv);
            descricao_tv = itemView.findViewById(R.id.descricao_tv);
        }
    }
}
