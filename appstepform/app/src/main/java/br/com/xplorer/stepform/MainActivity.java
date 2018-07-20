package br.com.xplorer.stepform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.models.City;
import lib.view.stepform.models.MultipleQuestion;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.Survey;
import lib.view.stepform.models.options.Option;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new ArrayList<>();


        Question<Boolean> question1 = new SingleQuestion<>("Questao 1", R.layout.layout_question_1);
        Question<String> question2  = new SingleQuestion<>("Questao 2", R.layout.layout_question_2);

        List<Option<City>> options = new ArrayList<>();
        Option<City> option = new Option<>(new City(1, "Itaquaquecetuba"), "Itaquaquecetuba");
        options.add(option);
        option = new Option<>(new City(2, "Poá"), "Poá");
        options.add(option);
        option = new Option<>(new City(3, "Ferraz de Vasconcelos"), "Ferraz de Vasconcelos");
        options.add(option);

        Question<City> question3 = new MultipleQuestion<>("Questao 3", R.layout.layout_question_3, options);


        questions.add(question1);
        questions.add(question2);
        questions.add(question3);


        Survey survey = new Survey(questions);
        survey.start(this);


    }
}
