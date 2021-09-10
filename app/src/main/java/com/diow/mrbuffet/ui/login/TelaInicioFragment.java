package com.diow.mrbuffet.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.diow.mrbuffet.CadastroActivity;
import com.diow.mrbuffet.MainActivity;
import com.diow.mrbuffet.R;
import com.diow.mrbuffet.ui.gallery.FavoritadosFragment;

public class TelaInicioFragment extends AppCompatActivity {
    private Button btn_continuar_inicio, btn_trabalhe_conosco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tela_inicio);

        btn_continuar_inicio = findViewById(R.id.btn_continuar_inicio);
        btn_trabalhe_conosco = findViewById(R.id.btn_trabalhe_conosco);

        btn_continuar_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirTelaDeLogin = new Intent(TelaInicioFragment.this, LoginActivity.class);
                startActivity(abrirTelaDeLogin);
                finish();
            }
        });

    }

//    private void abrirTelaDeLogin() {
//        Intent intent = new Intent(TelaInicioFragment.this, LoginActivity.class);
//        startActivity(intent);
//        finish();
//}
}
