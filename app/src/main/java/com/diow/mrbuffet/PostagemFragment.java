package com.diow.mrbuffet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diow.mrbuffet.adapter.PostagemAdapter;
import com.diow.mrbuffet.model.Postagem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class PostagemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private List<Postagem> postagens = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PostagemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PostagemFragment newInstance(int columnCount) {
        PostagemFragment fragment = new PostagemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postagem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
           // recyclerView.setAdapter(new PostagemAdapter(DummyContent.ITEMS));
            this.prepararPostagens();
            PostagemAdapter adapter = new PostagemAdapter(postagens);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    public void prepararPostagens() {
        Postagem p = new Postagem("Zook Buum",
                "Buffet infantil com atra????es modernas e atualizadas para crian??as e adultos, em um espa??o " +
                        "amplo com um servi??o de alimenta????o exclusivo. " +
                        "#ZooKBuuM #SuaFestaEst??Aqui", R.drawable.zookbuum);
        this.postagens.add(p);

        p = new Postagem("ViVa Festas", "O Buffet Viva Festas ?? " +
                "o lugar ideal para realizar a sua festa, garantindo ?? voc?? e a seus convidados, muito " +
                "conforto e divers??o e tornando a sua festa, um acontecimento inesquec??vel.\n" +
                "\n" +
                "Trabalhando com o conceito de que a cada festa o cliente est?? realizando um sonho, " +
                "temos procurado a excel??ncia de qualidade em tudo que fazemos.\n" +
                "\n" +
                "Contamos com uma equipe treinada e capacitada pronta para atender seus pedidos e os" +
                " de seus convidados, com muita cortesia e aten????o. Nossos monitores s??o atenciosos, " +
                "zelando pela seguran??a da garotada que se diverte nos brinquedos e fazendo de sua festa um momento m??gico e inesquec??vel."
                , R.drawable.viva_festas);
        this.postagens.add(p);

        p = new Postagem("Ciranda na Vila", "Facilidade para" +
                " a sua festa!", R.drawable.ciranda_na_vila);
        this.postagens.add(p);

        p = new Postagem("Buffet Infantil Penha", "Com o " +
                "intuito de facilitar e lhe ajudar na busca por Buffet Infantil Penha listamos nos " +
                "artigos abaixo os dez melhores buffets no bairro da Penha, para que voc?? n??o corra " +
                "o risco de contratar um servi??o que n??o oferece o que promete.\n" +
                "\n" +
                "Hoje em dia ?? comum encontrar com pessoas que j?? tiveram experi??ncias negativas ao " +
                "contratar um buffet que n??o cumpriu com o que prometia e em casos extremamente graves" +
                " alguns nem existiam fisicamente, ou seja, era apenas um falso perfil na internet.\n" +
                "\n" +
                "Mas calma! Pensando em tudo isso criamos esse portal para que a escolha do buffet " +
                "do seu filho ou filha seja muito tranquila e o mais importante segura.\n" +
                "\n" +
                "Pode come??ar a sua busca, abaixo ir?? encontrar os melhores buffets infantis da " +
                "Penha cada um com seu diferencial ?? s?? escolher o que mais tem a ver com o que procura.", R.drawable.penha);
        this.postagens.add(p);

        p = new Postagem("Allegro Bambini", "H?? 3 anos no " +
                "mercado, o Allegro Bambini ?? refer??ncia no segmento de buffet infantil.\n" +
                "\n" +
                "Em 2017 reinaugurou sob nova dire????o, trazendo sofistica????o e melhorias em seus " +
                "produtos, servi??os e em sua marca.\n" +
                "\n" +
                "O espa??o de 800 metros quadrados e com dez metros de altura tem brinquedos exclusivos" +
                " em S??o Caetano do Sul, entre eles, o carrinho bate-bate que pode ser usado por adulto." +
                " Al??m disso, o Allegro Bambini oferece uma grande variedade de card??pios.\n" +
                "\n" +
                "Temos a melhor estrutura para a realiza????o da festa do seu pequeno, trazendo sempre" +
                " qualidade do come??o ao final do servi??o. Temos um local divertido e aconchegante," +
                " ar condicionado, monitores treinados para animar sua festa e acompanhar os menores," +
                " atendimento de primeira, diversas op????es de brinqudos e gastronomia de qualidade.\n" +
                "\n" +
                "Com certeza a festa do seu pequeno ser?? de grande alegria e emo????o em nosso buffet.", R.drawable.bambini);
        this.postagens.add(p);

        p = new Postagem("Espa??o Formigueiro", "O anivers??rio" +
                " de uma crian??a ?? uma ocasi??o muito especial para ela e sua fam??lia.\n" +
                "\n" +
                "O canto do parab??ns, os abra??os e beijos dos amigos, os sorrisos de familiares e a " +
                "companhia de pessoas queridas, ajudam a crian??a a desenvolver sua capacidade de dar" +
                " e receber afeto.\n" +
                "\n" +
                "Para que este momento seja realmente especial, ?? importante que o espa??o escolhido" +
                " para a comemora????o seja aconchegante, agrad??vel e ofere??a seguran??a. Por isso, escolhemos areia, verde e muita madeira que trazem a sensa????o de contato com a natureza, de uma festa que acontece em um gostoso jardim.\n" +
                "\n" +
                "Assim s??o as nossas festas, regadas a alegria e descontra????o, com comidinhas gostosas" +
                " e um servi??o eficiente e cordial. Um espa??o diferente, onde realidade e faz de " +
                "conta se misturam de uma maneira m??gica e divertida, recheando este dia t??o especial" +
                " de emo????es e recorda????es inesquec??veis.", R.drawable.formigueiro);
        this.postagens.add(p);

        p = new Postagem("Pindorama", "O Espa??o Pindorama nasceu" +
                " do sonho de que ainda ?? poss??vel cercar cada festa de anivers??rio de significado.\n" +
                "\n" +
                "O dia do anivers??rio de uma crian??a ?? um dia m??gico e que toda crian??a que percebe " +
                "ser um motivo especial de comemora????o e se sente o centro da aten????o afetiva, recebe" +
                " amor, sente-se segura e feliz. Foi desta cren??a que nasceu o Espa??o Pindorama.\n" +
                "\n" +
                "Quem n??o se lembra do movimento que uma festa de anivers??rio produzia em toda fam??lia." +
                " Uma tia fazendo um bolo, mutir??o para encher bexigas e por a?? vai. Como n??o se sentir" +
                " amado e querido num contexto desses?!!\n" +
                "\n" +
                "O Espa??o Pindorama quer trazer de volta esse clima m??gico e transformar cada festa" +
                " de anivers??rio em uma festa ??nica, cheia de verdadeiros encontros com o objetivo de" +
                " transmitir amor, carinho e mostrar para cada aniversariante que se comemora o seu " +
                "nascimento por que ele ?? Especial.", R.drawable.pindorama);
        this.postagens.add(p);

        p = new Postagem("Buticabeira", "O maior buffet infantil" +
                " a c??u aberto de S??o Paulo. Localizado em um charmoso sobrado da d??cada de quarenta," +
                " o Espa??o Buticabeira combina sal??o de festas a atmosfera de quintal de casa. E que " +
                "quintal! Com ??rvores frut??feras como jabuticabeiras, amoreira, pitangueiras, ara??azeiro" +
                " e coqueiros distribu??das nos 800 metros quadrados do terreno.\n" +
                "\n" +
                "E o mais gostoso ?? que todas as ??rvores s??o altas e frondosas, pois foram plantadas " +
                "na ??poca da constru????o do im??vel, h?? setenta anos. As jabuticabeiras que inspiraram " +
                "o nome do lugar, por exemplo, t??m nada menos do que oito metros de altura.\n" +
                "\n" +
                "Mas al??m do lugar ser delicioso, h?? tamb??m muita divers??o ali. Por??m, bem diferente" +
                " dos buf??s convencionais, fliperama e eletr??nicos saem de cena. E d??o lugar a circuito" +
                " de arvorismo com tirolesa de carrinho, ponte de corda, escadinha suspensa, teia de " +
                "aranha, e, ainda, a uma parede de escalada com seis metros de altura. E n??o h?? limite" +
                " m??ximo de idade: o circuito comporta at?? mesmo adultos que quiserem se aventurar ao " +
                "lado dos filhos.", R.drawable.buticabeira);
        this.postagens.add(p);
    }
}