package com.example.paginalogin.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.paginalogin.R;
import com.example.paginalogin.controler.UsuarioController;
import com.example.paginalogin.model.Usuario;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Spinner spinner;
    private TextInputLayout inputCpf, inputNome, inputdata, inputcep,
    inputCidade, inputLogradouro, inputNumero, inputComplememto, inputTelefone,
    inputBairro, inputEmail, inputSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("LugaLuga Cadastro");
        setSupportActionBar(myToolbar);

        inputCpf = findViewById(R.id.input_cpf);
        inputNome = findViewById(R.id.input_nome);
        inputdata = findViewById(R.id.input_nascimento);
        inputcep = findViewById(R.id.input_cep);
        inputCidade = findViewById(R.id.input_cidade);
        inputLogradouro = findViewById(R.id.input_logradouro);
        inputNumero = findViewById(R.id.input_numero);
        inputComplememto = findViewById(R.id.input_complemento);
        inputTelefone = findViewById(R.id.input_numero);
        inputBairro = findViewById(R.id.input_bairro);
        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.text_senha);


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
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;

                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
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

        inputcep.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskCEP = "#####-###";
            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskCEP;

                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;

                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputcep.getEditText().setText(mascara);
                inputcep.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputdata.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskDATA = "##/##/####";
            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskDATA;

                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;

                    }

                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputdata.getEditText().setText(mascara);
                inputdata.getEditText().setSelection(mascara.length());
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

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioController crud = new UsuarioController(getApplicationContext());

                Usuario usuario = new Usuario();
                usuario.setNome(inputNome.getEditText().getText().toString());
                usuario.setCpf(inputCpf.getEditText().getText().toString());
                usuario.setDataNasc(inputdata.getEditText().getText().toString());
                usuario.setCep(inputcep.getEditText().getText().toString());
                usuario.setCidade(inputCidade.getEditText().getText().toString());
                usuario.setLogradouro(inputLogradouro.getEditText().getText().toString());
                usuario.setNumero(Integer.parseInt(inputNumero.getEditText().getText().toString()));
                usuario.setComplemento(inputComplememto.getEditText().getText().toString());
                usuario.setTelefone(inputTelefone.getEditText().getText().toString());
                usuario.setBairro(inputBairro.getEditText().getText().toString());
                usuario.setEmail(inputEmail.getEditText().getText().toString());
                usuario.setSenha(inputSenha.getEditText().getText().toString());

                String resultado;


                resultado = crud.insereDados(usuario.getNome(), usuario.getCpf(), usuario.getDataNasc(), usuario.getCep(),
                        usuario.getCidade(), usuario.getLogradouro(), usuario.getNumero(), usuario.getComplemento(),
                        usuario.getTelefone(),usuario.getBairro(),usuario.getEmail(),usuario.getSenha());

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });


    }
}
