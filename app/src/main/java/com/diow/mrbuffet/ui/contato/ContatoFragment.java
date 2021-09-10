package com.diow.mrbuffet.ui.contato;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContatoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContatoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContatoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContatoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContatoFragment newInstance(String param1, String param2) {
        ContatoFragment fragment = new ContatoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Element titulo = new Element();
        titulo.setTitle("Nunca foi tão fácil anunciar o seu negócio por aqui, o Mr.Buffet te ajudará a dar uma 'alavancada' em sua carreira, " +
                "divulgamos diariamente buffets de todas as regiões para pessoas do Brasil inteiro, " +
                "venha e mostre o seu Buffet aqui e ajude a todos terem a festa perfeita! Acesse e " +
                "inscreva-se em nosso site, com propriedades exclusivas para o gerenciamento de seu anúncio," +
                " você sempre será notificado dos interessados, podendo fazer reajustes e sempre" +
                " inovando o atualizamento de seu anúncio.");
        String descricao = "TEM UMA EMPRESA DE BUFFET E DESEJA ANUNCIÁ-LA AQUI!? saiba mais em " +
                "nosso site especializado para isto:";
        return new AboutPage(getActivity())
                //.setImage(R.drawable.logo)
                .addItem(titulo)
                .setDescription(descricao)
                .addGroup("Entre em contato conosco:")
                .addWebsite("https://mehdisakout.com/", "Acesse nosso site")
                .addEmail("mrbufeet@gmail.com", "Envie-nos um e-mail")
                .create();
    }
}