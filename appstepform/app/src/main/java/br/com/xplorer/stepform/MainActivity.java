package br.com.xplorer.stepform;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.models.City;
import br.com.xplorer.stepform.models.Role;
import br.com.xplorer.stepform.question.manager.Question1;
import br.com.xplorer.stepform.question.manager.Question2;
import br.com.xplorer.stepform.question.manager.Question3;
import br.com.xplorer.stepform.question.manager.Question4;
import lib.view.stepform.models.Answer;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.Survey;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new ArrayList<>();


        ValidationAnswer<Boolean> validationAnswer1 = new ValidationAnswer<Boolean>() {
            @Override
            public boolean validate(Answer<Boolean> answer) {
                return false;
            }
        };
        Question<Boolean> question1 = new Question1<>(validationAnswer1
                ,"Questao 1", R.layout.layout_question_1, this);


        ValidationAnswer<String> validationAnswer2 = new ValidationAnswer<String>() {
            @Override
            public boolean validate(Answer<String> answer) {
                return false;
            }
        };
        Question<String> question2 = new Question2<>(validationAnswer2
                ,"Questao 2", R.layout.layout_question_2, this);


        List<Option<City>> optionsQuestion3 = new ArrayList<>();
        Option<City> option = new Option<>(new City(1, "Itaquaquecetuba"), "Itaquaquecetuba");
        optionsQuestion3.add(option);
        option = new Option<>(new City(2, "Poá"), "Poá");
        optionsQuestion3.add(option);
        option = new Option<>(new City(3, "Ferraz de Vasconcelos"), "Ferraz de Vasconcelos");
        optionsQuestion3.add(option);
        ValidationAnswer<City> validationAnswer3 = new ValidationAnswer<City>() {
            @Override
            public boolean validate(Answer<City> answer) {
                return false;
            }
        };
        Question<City> question3 = new Question3<>(validationAnswer3
                , "Questao 3", R.layout.layout_question_3, optionsQuestion3, this);


        List<Option<Role>> optionsQuestion4 = new ArrayList<>();
        optionsQuestion4.add(new Option<>(new Role(1, "Engenheiro de Software"), "Engenheiro de Software"));
        optionsQuestion4.add(new Option<>(new Role(2, "Analista de Sistemas"), "Analista de Sistemas"));
        optionsQuestion4.add(new Option<>(new Role(3, "Engenheiro de Hardware"), "Engenheiro de Hardware"));
        optionsQuestion4.add(new Option<>(new Role(4, "Analista de Redes"), "Analista de Redes"));
        optionsQuestion4.add(new Option<>(new Role(5, "Técnico de Redes"), "Técnico de Redes"));
        ValidationAnswer<Role> validationAnswer4 = new ValidationAnswer<Role>() {
            @Override
            public boolean validate(@Nullable Answer<Role> answer) {
                return false;
            }
        };
        Question<Role> question4 = new Question4<>(validationAnswer4, "Cargos existentes na T.I - Questão 4"
                , R.layout.layout_question_4, optionsQuestion4, this);


        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        Survey survey = new Survey(questions);
        survey.start(this);
    }
}
