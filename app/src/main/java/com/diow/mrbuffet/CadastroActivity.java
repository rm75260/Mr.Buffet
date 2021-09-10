package com.diow.mrbuffet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.diow.mrbuffet.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private EditText et_nome_registro, et_email_registro,
            et_senha_registro, et_conf_senha_registro;
    private TextView btn_login_registro;
    private CheckBox ckb_mostrar_senha_cadastro;
    private Button btn_registrar_cadastro;
    private ProgressBar cadastroProgressBar;
    private FirebaseAuth mAuth;
//    private String usu;
//    private LinearLayout layoutLoginCadastro;
//    private int nivel = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_layout);

//        // ACIONAMENTO DO BOTÃO DE REGISTRO NO BANCO
//        btn_registrar_cadastro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // fazer o crud de insert no banco
//            }
//        });
//
//        // CRIAR VINCULO COM NOME E CONFIRMAR SENHA

        mAuth = FirebaseAuth.getInstance();

        et_nome_registro = findViewById(R.id.et_nome_registro);
        et_email_registro = findViewById(R.id.et_email_registro);
        et_senha_registro = findViewById(R.id.et_senha_registro);
        et_conf_senha_registro = findViewById(R.id.et_conf_senha_registro);
        btn_registrar_cadastro = findViewById(R.id.btn_registrar_cadastro);
        ckb_mostrar_senha_cadastro = findViewById(R.id.ckb_mostrar_senha_cadastro);
        cadastroProgressBar = findViewById(R.id.cadastroProgressBar);
        btn_login_registro = findViewById(R.id.btn_login_registro);


        ckb_mostrar_senha_cadastro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    et_senha_registro.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    et_conf_senha_registro.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    et_senha_registro.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    et_conf_senha_registro.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        btn_registrar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String registrarEmail = et_email_registro.getText().toString();
                String senha = et_senha_registro.getText().toString();
                String confirmarSenha = et_conf_senha_registro.getText().toString();

                if (!TextUtils.isEmpty(registrarEmail) || !TextUtils.isEmpty(senha) || !TextUtils.isEmpty(confirmarSenha)){
                    if (senha.equals(confirmarSenha)){
                        cadastroProgressBar.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(registrarEmail, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    abrirTelaPrincipal();
                                }else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(CadastroActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                                }
                                cadastroProgressBar.setVisibility(View.INVISIBLE);
                            }
                        });
                    }else {
                        Toast.makeText(CadastroActivity.this, "A senha deve " +
                                "ser a mesma para ambos os campos!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_login_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        inicializarComponentes();
//        Intent it = getIntent();
//        usu = it.getStringExtra("usu1");
//        et_nome_registro.setText(usu);
//        btn_registrar_registro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO - CONECTAR NO BANCO E VERIFICAR USUARIO E SENHA
//                usu = et_nome_registro.getText().toString();
//                String sen = et_senha_registro.getText().toString();
//                String ema = et_email_registro.getText().toString();
//                Conexao.inserirUsuario(v, usu, sen, ema);
//                finish();
//            }
//        });

    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

//    private void inicializarComponentes() {
//        //layoutLoginCadastro = findViewById(R.id.registro_layout);
//        // registroLayout = findViewById(R.id.registro_layout);
//        et_nome_registro = findViewById(R.id.et_nome_registro);
//        et_senha_registro = findViewById(R.id.et_senha_registro);
//        et_email_registro = findViewById(R.id.et_email_registro);
//        btn_registrar_cadastro = findViewById(R.id.btn_registrar_cadastro);
//
//    }
}