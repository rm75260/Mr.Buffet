package com.diow.mrbuffet.ui.sobre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.diow.mrbuffet.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SobreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SobreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SobreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SobreFragment newInstance(String param1, String param2) {
        SobreFragment fragment = new SobreFragment();
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
        String descricao = "O nosso aplicativo foi criado com o intu??to de ajudar a todos que est??o em busca " +
                "da festa perfeita, devido ??s in??meras dificuldades que analisamos no dia ?? dia ao decidirmos" +
                " buscarmos por op????es de buffets mais pr??ximas ou at?? mesmo um com o pre??o mais acess??vel," +
                " por isso o Mr.Buffet ?? a melhor op????o para a sua celebra????o." +
                " Nunca foi t??o f??cil achar a sua Melhor Festa!" ;
        Element versao = new Element();
        versao.setTitle("Vers??o 1.0.1");
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
        return new AboutPage(getActivity())
                /*.isRTL(false)
                .enableDarkMode(false)
                .setCustomFont(String) // or Typeface
                 */
                .setImage(R.drawable.cartola_nova)
                .setDescription(descricao)
                .addGroup("Acompanhe nossas Redes Sociais:")
                .addInstagram("mrbuffet_app", "Instagram")
                .addFacebook("MrBuffetapp","Facebook")
                .addTwitter("MrBuffetapp","Twitter")
                //.addYoutube("UCdPQtdWIsg7_pi4mrRu46vA", "YouTube" )
                //.addGitHub("medyo", "GitHub")
                .addGroup("Avalie-nos na PlayStore")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addItem(versao)
                .create();

    }
}