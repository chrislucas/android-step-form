package br.com.xplorer.stepform;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.models.City;
import br.com.xplorer.stepform.models.Role;
import br.com.xplorer.stepform.question.manager.ManagerQuestion1;
import br.com.xplorer.stepform.question.manager.ManagerQuestion2;
import br.com.xplorer.stepform.question.manager.ManagerQuestion3;
import br.com.xplorer.stepform.question.manager.ManagerQuestion4;
import lib.view.stepform.models.Answer;
import lib.view.stepform.models.MultipleQuestion;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.SingleQuestion;
import lib.view.stepform.models.Survey;
import lib.view.stepform.action.ManagerLayoutQuestion;
import lib.view.stepform.action.ValidationAnswer;
import lib.view.stepform.models.options.Option;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new ArrayList<>();

        ManagerLayoutQuestion mg1 = new ManagerQuestion1(this);
        ValidationAnswer<Boolean> validationAnswer1 = new ValidationAnswer<Boolean>() {
            @Override
            public boolean validate(Answer<Boolean> answer) {
                return false;
            }
        };
        Question<Boolean> question1 = new SingleQuestion<>(mg1
                , validationAnswer1,"Questao 1", R.layout.layout_question_1);

        ManagerLayoutQuestion mg2 = new ManagerQuestion2(this);
        ValidationAnswer<String> validationAnswer2 = new ValidationAnswer<String>() {
            @Override
            public boolean validate(Answer<String> answer) {
                return false;
            }
        };
        Question<String> question2 = new SingleQuestion<>(mg2,
                validationAnswer2,"Questao 2", R.layout.layout_question_2);


        ManagerLayoutQuestion mg3 = new ManagerQuestion3(this);
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
        Question<City> question3 = new SingleQuestion<>(mg3
                , validationAnswer3, "Questao 3", R.layout.layout_question_3, optionsQuestion3);


        List<Option<Role>> optionsQuestion4 = new ArrayList<>();
        optionsQuestion4.add(new Option<>(new Role(1, "Engenheiro de Software"), "Engenheiro de Software"));
        optionsQuestion4.add(new Option<>(new Role(2, "Analista de Sistemas"), "Analista de Sistemas"));
        optionsQuestion4.add(new Option<>(new Role(3, "Engenheiro de Hardware"), "Engenheiro de Hardware"));
        optionsQuestion4.add(new Option<>(new Role(4, "Analista de Redes"), "Analista de Redes"));
        optionsQuestion4.add(new Option<>(new Role(5, "Técnico de Redes"), "Técnico de Redes"));

        ManagerLayoutQuestion mg4 = new ManagerQuestion4(this);
        ValidationAnswer<Role> validationAnswer4 = new ValidationAnswer<Role>() {
            @Override
            public boolean validate(@Nullable Answer<Role> answer) {
                return false;
            }
        };
        Question question4 = new MultipleQuestion<>(mg4, validationAnswer4
                , "Cargos existentes na T.I - Questão 4"
                , R.layout.layout_question_4, optionsQuestion4);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        Survey survey = new Survey(questions);
        survey.start(this);
    }
}
