package com.example.kori.ui.cities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.kori.R;

import java.util.ArrayList;
import java.util.List;

public class CitiesFragment extends Fragment {

    private Spinner citySpinner;
    private GridView cityGrid;

    private List<CityItem> allCities;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cities, container, false);

        citySpinner = root.findViewById(R.id.city_spinner);
        cityGrid = root.findViewById(R.id.city_grid);

        //lista de cidades
        allCities = new ArrayList<>();
        allCities.add(new CityItem(
                "Tóquio",
                "O Epicentro da Modernidade Japonesa",
                "Tóquio é uma metrópole vibrante onde tradição e inovação se encontram. A cidade é marcada por arranha-céus, luzes de néon, tecnologia de ponta e uma cena cultural agitada em bairros como Shibuya e Akihabara, mas também conserva templos antigos e jardins tranquilos que refletem o respeito japonês pelo passado.\n\nApesar de sua aparência futurista, Tóquio mantém uma identidade forte, com espaços que celebram a espiritualidade, a estética e a história. A cidade também é referência mundial em gastronomia, estilo de vida urbano e reconstrução, mostrando como se reinventar sem perder suas raízes.",
                R.drawable.background_tokyo,
                R.raw.sound_tokyo
        ));

        allCities.add(new CityItem(
                "Kyoto",
                "O Refúgio da Tradição Japonesa",
                "Kyoto é o coração da tradição japonesa. A cidade preserva templos milenares, santuários, jardins e rituais que resistem ao tempo, criando uma atmosfera espiritual e contemplativa. Em cada rua de Gion ou entre as trilhas da floresta de bambu de Arashiyama, sente-se a história viva do Japão imperial.\n\nAlém de sua arquitetura e paisagens encantadoras, Kyoto oferece experiências gastronômicas refinadas com a culinária kaiseki, que valoriza ingredientes sazonais e a estética dos pratos. É um lugar que convida ao silêncio, ao respeito e à conexão com o Japão mais profundo.",
                R.drawable.background_kyoto,
                R.raw.sound_kyoto
        ));

        allCities.add(new CityItem(
                "Osaka",
                "O Paraíso Gastronômico do Japão", "Osaka é sinônimo de comida boa, gente simpática e vida urbana animada. É uma cidade alegre e acessível, onde o espírito descontraído se mistura com uma tradição mercante forte. Mercados, izakayas e barraquinhas de comida revelam pratos como takoyaki e okonomiyaki, que fazem parte da alma local.\n" +
                "\n" +
                "Mais do que um destino gastronômico, Osaka também tem história, com o majestoso Castelo de Osaka e bairros cheios de personalidade como Namba e Dotonbori. A cidade pulsa com vida e mostra o lado mais caloroso e divertido do Japão.",
                R.drawable.background_osaka,
                R.raw.sound_osaka
        ));

        allCities.add(new CityItem(
                "Nara",
                "Encontro com os Cervos Sagrados",
                "Nara é uma cidade calma e histórica onde os cervos caminham livremente entre templos e parques. Eles são considerados mensageiros sagrados, e sua presença transmite paz e harmonia. Nara foi a primeira capital permanente do Japão e guarda relíquias como o Tōdai-ji, lar de uma das maiores estátuas de Buda do mundo.\n" +
                        "\n" +
                        "Cercada por natureza e tradição, Nara proporciona uma experiência serena e autêntica. Suas paisagens e templos convidam à contemplação, enquanto o contato com os animais reforça a ligação espiritual que define o espírito japonês.",
                R.drawable.background_nara,
                R.raw.sound_nara
        ));


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<CityItem> selected = new ArrayList<>();
                selected.add(allCities.get(position)); // só uma cidade
                GridViewAdapter gridAdapter = new GridViewAdapter(getContext(), selected);
                cityGrid.setAdapter(gridAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cityGrid.setAdapter(null);
            }
        });

        return root;
    }
}
