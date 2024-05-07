package com.example.paginalogin.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produto implements Parcelable {
    private String nome;

    private String descricao;

    private String quantidade;

    private String valor;

    public Produto(String nome, String descricao, String quantidade, String valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    protected Produto(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        quantidade = in.readString();
        valor = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeString(quantidade);
        dest.writeString(valor);
    }
}


