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
                "Buffet infantil com atrações modernas e atualizadas para crianças e adultos, em um espaço " +
                        "amplo com um serviço de alimentação exclusivo. " +
                        "#ZooKBuuM #SuaFestaEstáAqui", R.drawable.zookbuum);
        this.postagens.add(p);

        p = new Postagem("ViVa Festas", "O Buffet Viva Festas é " +
                "o lugar ideal para realizar a sua festa, garantindo à você e a seus convidados, muito " +
                "conforto e diversão e tornando a sua festa, um acontecimento inesquecível.\n" +
                "\n" +
                "Trabalhando com o conceito de que a cada festa o cliente está realizando um sonho, " +
                "temos procurado a excelência de qualidade em tudo que fazemos.\n" +
                "\n" +
                "Contamos com uma equipe treinada e capacitada pronta para atender seus pedidos e os" +
                " de seus convidados, com muita cortesia e atenção. Nossos monitores são atenciosos, " +
                "zelando pela segurança da garotada que se diverte nos brinquedos e fazendo de sua festa um momento mágico e inesquecível."
                , R.drawable.viva_festas);
        this.postagens.add(p);

        p = new Postagem("Ciranda na Vila", "Facilidade para" +
                " a sua festa!", R.drawable.ciranda_na_vila);
        this.postagens.add(p);

        p = new Postagem("Buffet Infantil Penha", "Com o " +
                "intuito de facilitar e lhe ajudar na busca por Buffet Infantil Penha listamos nos " +
                "artigos abaixo os dez melhores buffets no bairro da Penha, para que você não corra " +
                "o risco de contratar um serviço que não oferece o que promete.\n" +
                "\n" +
                "Hoje em dia é comum encontrar com pessoas que já tiveram experiências negativas ao " +
                "contratar um buffet que não cumpriu com o que prometia e em casos extremamente graves" +
                " alguns nem existiam fisicamente, ou seja, era apenas um falso perfil na internet.\n" +
                "\n" +
                "Mas calma! Pensando em tudo isso criamos esse portal para que a escolha do buffet " +
                "do seu filho ou filha seja muito tranquila e o mais importante segura.\n" +
                "\n" +
                "Pode começar a sua busca, abaixo irá encontrar os melhores buffets infantis da " +
                "Penha cada um com seu diferencial é só escolher o que mais tem a ver com o que procura.", R.drawable.penha);
        this.postagens.add(p);

        p = new Postagem("Allegro Bambini", "Há 3 anos no " +
                "mercado, o Allegro Bambini é referência no segmento de buffet infantil.\n" +
                "\n" +
                "Em 2017 reinaugurou sob nova direção, trazendo sofisticação e melhorias em seus " +
                "produtos, serviços e em sua marca.\n" +
                "\n" +
                "O espaço de 800 metros quadrados e com dez metros de altura tem brinquedos exclusivos" +
                " em São Caetano do Sul, entre eles, o carrinho bate-bate que pode ser usado por adulto." +
                " Além disso, o Allegro Bambini oferece uma grande variedade de cardápios.\n" +
                "\n" +
                "Temos a melhor estrutura para a realização da festa do seu pequeno, trazendo sempre" +
                " qualidade do começo ao final do serviço. Temos um local divertido e aconchegante," +
                " ar condicionado, monitores treinados para animar sua festa e acompanhar os menores," +
                " atendimento de primeira, diversas opções de brinqudos e gastronomia de qualidade.\n" +
                "\n" +
                "Com certeza a festa do seu pequeno será de grande alegria e emoção em nosso buffet.", R.drawable.bambini);
        this.postagens.add(p);

        p = new Postagem("Espaço Formigueiro", "O aniversário" +
                " de uma criança é uma ocasião muito especial para ela e sua família.\n" +
                "\n" +
                "O canto do parabéns, os abraços e beijos dos amigos, os sorrisos de familiares e a " +
                "companhia de pessoas queridas, ajudam a criança a desenvolver sua capacidade de dar" +
                " e receber afeto.\n" +
                "\n" +
                "Para que este momento seja realmente especial, é importante que o espaço escolhido" +
                " para a comemoração seja aconchegante, agradável e ofereça segurança. Por isso, escolhemos areia, verde e muita madeira que trazem a sensação de contato com a natureza, de uma festa que acontece em um gostoso jardim.\n" +
                "\n" +
                "Assim são as nossas festas, regadas a alegria e descontração, com comidinhas gostosas" +
                " e um serviço eficiente e cordial. Um espaço diferente, onde realidade e faz de " +
                "conta se misturam de uma maneira mágica e divertida, recheando este dia tão especial" +
                " de emoções e recordações inesquecíveis.", R.drawable.formigueiro);
        this.postagens.add(p);

        p = new Postagem("Pindorama", "O Espaço Pindorama nasceu" +
                " do sonho de que ainda é possível cercar cada festa de aniversário de significado.\n" +
                "\n" +
                "O dia do aniversário de uma criança é um dia mágico e que toda criança que percebe " +
                "ser um motivo especial de comemoração e se sente o centro da atenção afetiva, recebe" +
                " amor, sente-se segura e feliz. Foi desta crença que nasceu o Espaço Pindorama.\n" +
                "\n" +
                "Quem não se lembra do movimento que uma festa de aniversário produzia em toda família." +
                " Uma tia fazendo um bolo, mutirão para encher bexigas e por aí vai. Como não se sentir" +
                " amado e querido num contexto desses?!!\n" +
                "\n" +
                "O Espaço Pindorama quer trazer de volta esse clima mágico e transformar cada festa" +
                " de aniversário em uma festa única, cheia de verdadeiros encontros com o objetivo de" +
                " transmitir amor, carinho e mostrar para cada aniversariante que se comemora o seu " +
                "nascimento por que ele é Especial.", R.drawable.pindorama);
        this.postagens.add(p);

        p = new Postagem("Buticabeira", "O maior buffet infantil" +
                " a céu aberto de São Paulo. Localizado em um charmoso sobrado da década de quarenta," +
                " o Espaço Buticabeira combina salão de festas a atmosfera de quintal de casa. E que " +
                "quintal! Com árvores frutíferas como jabuticabeiras, amoreira, pitangueiras, araçazeiro" +
                " e coqueiros distribuídas nos 800 metros quadrados do terreno.\n" +
                "\n" +
                "E o mais gostoso é que todas as árvores são altas e frondosas, pois foram plantadas " +
                "na época da construção do imóvel, há setenta anos. As jabuticabeiras que inspiraram " +
                "o nome do lugar, por exemplo, têm nada menos do que oito metros de altura.\n" +
                "\n" +
                "Mas além do lugar ser delicioso, há também muita diversão ali. Porém, bem diferente" +
                " dos bufês convencionais, fliperama e eletrônicos saem de cena. E dão lugar a circuito" +
                " de arvorismo com tirolesa de carrinho, ponte de corda, escadinha suspensa, teia de " +
                "aranha, e, ainda, a uma parede de escalada com seis metros de altura. E não há limite" +
                " máximo de idade: o circuito comporta até mesmo adultos que quiserem se aventurar ao " +
                "lado dos filhos.", R.drawable.buticabeira);
        this.postagens.add(p);
    }
}