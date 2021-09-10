package com.diow.mrbuffet.ui.login;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.diow.mrbuffet.CadastroActivity;
import com.diow.mrbuffet.MainActivity;
import com.diow.mrbuffet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText et_email, et_senha;
    private Button btn_login;
    private TextView btn_registrar_se;
    private FirebaseAuth mAuth;
    private ProgressBar loginProgressBar;
    private CheckBox ckb_mostrar_senha_login;
    // private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        et_email = findViewById(R.id.et_email_login);
        et_senha = findViewById(R.id.et_senha_login);
        btn_login = findViewById(R.id.btn_login);
        loginProgressBar = findViewById(R.id.cadastroProgressBar);
        btn_registrar_se = findViewById(R.id.btn_registar_se);
        ckb_mostrar_senha_login = findViewById(R.id.ckb_mostrar_senha_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmail = et_email.getText().toString();
                String loginSenha = et_senha.getText().toString();

                if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)) {
                    //loginProgressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail, loginSenha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        abrirTelaPrincipal();
                                    }else {
                                        String error = task.getException().getMessage();
                                        Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                                       // loginProgressBar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        btn_registrar_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ckb_mostrar_senha_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et_senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et_senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


//                    if (senha.equals(confirmarSenha)){
//                        cadastroProgressBar.setVisibility(View.VISIBLE);
//                        mAuth.createUserWithEmailAndPassword(registrarEmail, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()){
//                                    abrirTelaPrincipal();
//                                }
//                            }
//                        });
//                    }
//                }
//            }
//        });


//        tv_registro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);
//
//        final EditText usernameEditText = findViewById(R.id.et_email_login);
//        final EditText passwordEditText = findViewById(R.id.et_senha_login);
//        final Button loginButton = findViewById(R.id.btn_login);
//        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
//
//        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
//            @Override
//            public void onChanged(@Nullable LoginFormState loginFormState) {
//                if (loginFormState == null) {
//                    return;
//                }
//                loginButton.setEnabled(loginFormState.isDataValid());
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
//            }
//        });

//        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
//            @Override
//            public void onChanged(@Nullable LoginResult loginResult) {
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    //updateUiWithUser(loginResult.getSuccess());
//
//                    // REALIZAR TROCA DE JANELA
//                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
//                    // passar informação para outra janela
//                    it.putExtra("email", usernameEditText.getText().toString());
//                    startActivity(it);
//                }
//                setResult(Activity.RESULT_OK);
//
//                //Complete and destroy login activity once successful
//                //finish();
//            }
//        });
//
//        TextWatcher afterTextChangedListener = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // ignore
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // ignore
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        };
//        usernameEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.addTextChangedListener(afterTextChangedListener);
//        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    loginViewModel.login(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//                return false;
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//            }
//        });
//    }


//    private void updateUiWithUser(LoggedInUserView model) {
//        String welcome = getString(R.string.welcome) + model.getDisplayName();
//        // TODO : initiate successful logged in experience
//        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//    }
//
//    private void showLoginFailed(@StringRes Integer errorString) {
//        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
//    }
//}