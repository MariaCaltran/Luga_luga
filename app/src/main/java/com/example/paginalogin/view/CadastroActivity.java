package com.example.paginalogin.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.paginalogin.R;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextInputLayout inputCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("LugaLuga Cadastro");
        setSupportActionBar(myToolbar);

        inputCpf = findViewById(R.id.input_cpf);
        inputCpf.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;

            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskCPF;

                    String mascara = "";
                    if (isUpdating){
                        old = str;
                        isUpdating = false;
                        return;
                }
                    int i = 0;
                    for (char m : mask.toCharArray()) {
                        if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)){
                            mascara += m;
                            continue;

                        }

                        try {
                            mascara += str.charAt(i);
                        } catch (Exception e){
                            break;
                        }
                        i++;
                    }
                    isUpdating = true;
                    inputCpf.getEditText().setText(mascara);
                    inputCpf.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinner = (Spinner) findViewById(R.id.input_uf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
