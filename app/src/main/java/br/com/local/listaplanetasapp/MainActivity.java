package br.com.local.listaplanetasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Conteúdo que será inserido na ListView
    String nomePlanetas[] = {"A Montanha Mágica", "A Queda de Gondolin", "A Regra é Não Ter Regras",
    "A Vida Não é Útil", "Admirável Mundo Novo", "Calibã e a Bruxa", "Cidades Para Pessoas",
    "Essencialismo", "Estou Pensando em Acabar com Tudo", "Extraordinário", "Mindset: A Nova Psicologia do Sucesso",
    "Mulheres Que Correm Com os Lobos", "O Mundo Assombrados Pelos Demônios", "O Oráculo da Noite",
    "Por Que Nós Dormimos", "Princípios", "Rápido e Devagar", "Sapiens", "Um Lugar Bem Longe Daqui",
    "Uma Breve História do Tempo"};

    int imgPlanetas[] = {R.drawable.a_montanha_magica, R.drawable.a_queda_de_gondolin, R.drawable.a_regra_e_nao_ter_regras,
            R.drawable.a_vida_nao_e_util, R.drawable.admiravel_mundo_novo, R.drawable.caliba_e_a_bruxa,
            R.drawable.cidades_para_pessoas, R.drawable.essencialismo, R.drawable.estou_pensando_em_acabar_com_tudo,
            R.drawable.extraordinario, R.drawable.mindset_a_nova_psicologia_do_sucesso, R.drawable.mulheres_que_correm_com_os_lobos,
            R.drawable.o_mundo_assombrado_pelos_demonios, R.drawable.o_oraculo_da_noite, R.drawable.por_que_nos_dormimos,
            R.drawable.principios, R.drawable.rapido_e_devagar, R.drawable.sapiens, R.drawable.um_lugar_bem_longe_daqui,
            R.drawable.uma_breve_historia_do_tempo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarando a listView java com o XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o adaptador para instânciar o modelo layout a listView
        CustomAdapter adapter = new CustomAdapter();

        //Neste momento será feita a implementação da lista
        listView.setAdapter(adapter);

        //Implementar o click no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              Intent intent = new Intent(getApplicationContext(),VisualizaPlanetas_Activity.class);
              //É necessário utilizar o intent para passar os valores para outra activity
                //Implementar o putExtra

                intent.putExtra("nomePlanetas",nomePlanetas[i]);
                intent.putExtra("imgPlanetas",imgPlanetas[i]);

                startActivity(intent);

            }
        });
    }

    //Criar o objeto ou a classe CustomAdapter extendendo o BaseAdapter
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Método que irá instânciar o modelo
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            TextView txtNomePlanetas;
            ImageView imagemPlanetas;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_planetas_layout,null);

            txtNomePlanetas = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlanetas = carregaView.findViewById(R.id.imgListaPlaneta);

            txtNomePlanetas.setText(nomePlanetas[i]);
            imagemPlanetas.setImageResource(imgPlanetas[i]);


            return carregaView;
        }
    }

}