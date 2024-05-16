package com.example.paginalogin.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paginalogin.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private TextInputLayout inputEmail, inputSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.text_senha);
        btnEntrar = findViewById(R.id.btn_entrar);
        btnCadastrar = findViewById(R.id.btn_cadastrar_Login);

        Intent intent = new Intent(this, MainActivity.class);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaEmailSenha();
                startActivity(intent);
            }

        });


        Intent intent2 = new Intent(this, CadastroActivity.class);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }

        });


    }

    public boolean validaEmailSenha(){
        if (inputEmail.getEditText() != null
                && inputEmail.getEditText().getText().toString().equals(" ")){
            inputEmail.setError("Informe o Email");
            return false;
        }
        if (inputSenha.getEditText() != null
                && inputSenha.getEditText().getText().toString().equals(" ")) {
            inputSenha.setError("Informe a Senha");
            return true;

        }
        return true;
    }


}