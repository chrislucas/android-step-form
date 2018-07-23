package br.com.xplorer.stepform;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.adapters.spinner.AdapterSpinnerOptions;
import br.com.xplorer.stepform.models.City;
import br.com.xplorer.stepform.models.Role;
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

        ManagerLayoutQuestion mg = new ManagerLayoutQuestion() {
            @Override
            public void bindLayoutWithQuestion(Question question) {
                View viewRootQuestion1 = question.getView(MainActivity.this);
                if (viewRootQuestion1 != null) {
                    ( (TextView) viewRootQuestion1.findViewById(R.id.title_question_1))
                            .setText(question.getQuestionText());
                }
            }
        };

        ValidationAnswer<Boolean> validationAnswer1 = new ValidationAnswer<Boolean>() {
            @Override
            public boolean validate(Answer<Boolean> answer) {
                return false;
            }
        };

        Question<Boolean> question1 = new SingleQuestion<>(
                mg
            , validationAnswer1
            ,"Questao 1"
            , R.layout.layout_question_1
        );

        ManagerLayoutQuestion mg2 = new ManagerLayoutQuestion() {
            @Override
            public void bindLayoutWithQuestion(Question question) {
                View viewRootQuestion1 = question.getView(MainActivity.this);
                if (viewRootQuestion1 != null) {
                    ( (TextView) viewRootQuestion1.findViewById(R.id.title_question_2))
                            .setText(question.getQuestionText());
                }
            }
        };

        ValidationAnswer<String> validationAnswer2 = new ValidationAnswer<String>() {
            @Override
            public boolean validate(Answer<String> answer) {
                return false;
            }
        };

        Question<String> question2  = new SingleQuestion<>(
                mg2,
                validationAnswer2
            ,"Questao 2"
            , R.layout.layout_question_2
        );

        List<Option<City>> options = new ArrayList<>();
        Option<City> option = new Option<>(new City(1, "Itaquaquecetuba"), "Itaquaquecetuba");
        options.add(option);
        option = new Option<>(new City(2, "Poá"), "Poá");
        options.add(option);
        option = new Option<>(new City(3, "Ferraz de Vasconcelos"), "Ferraz de Vasconcelos");
        options.add(option);

        ManagerLayoutQuestion mg3 = new ManagerLayoutQuestion() {
            @Override
            public void bindLayoutWithQuestion(Question question) {
                SingleQuestion<City> singleQuestion = (SingleQuestion<City>) question;
                View viewRoot = question.getView(MainActivity.this);
                ((TextView) viewRoot.findViewById(R.id.title_question_3)).setText(question.getQuestionText());

                Spinner citiesOptions = viewRoot.findViewById(R.id.cities_options);

                final List<Option<City>> options = singleQuestion.getOptions();

                AdapterSpinnerOptions<City> adapter =
                        new AdapterSpinnerOptions<>(MainActivity.this
                                , R.layout.custom_text_item_spinner
                                , options
                                );

                citiesOptions.setAdapter(adapter);

                citiesOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Option<City> option = options.get(position);
                        City city = option.getData();
                        Toast.makeText(MainActivity.this
                                , city.getName(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }
        };

        ValidationAnswer<City> validationAnswer3 = new ValidationAnswer<City>() {
            @Override
            public boolean validate(Answer<City> answer) {
                return false;
            }
        };

        Question<City> question3 = new SingleQuestion<>(
                mg3
                , validationAnswer3
                , "Questao 3"
                , R.layout.layout_question_3
                , options
        );


        List<Option<Role>> options2 = new ArrayList<>();
        options2.add(new Option<Role>(new Role(1, "Engenheiro de Software"), "Engenheiro de Software"));
        options2.add(new Option<Role>(new Role(2, "Analista de Sistemas"), "Analista de Sistemas"));
        options2.add(new Option<Role>(new Role(3, "Engenheiro de Hardware"), "Engenheiro de Hardware"));
        options2.add(new Option<Role>(new Role(4, "Analista de Redes"), "Analista de Redes"));
        options2.add(new Option<Role>(new Role(5, "Técnico de Redes"), "Técnico de Redes"));


        ManagerLayoutQuestion mg4 = new ManagerLayoutQuestion() {
            @Override
            public void bindLayoutWithQuestion(Question question) {

            }
        };

        ValidationAnswer<Role> validationAnswer4 = new ValidationAnswer<Role>() {
            @Override
            public boolean validate(@Nullable Answer<Role> answer) {
                return false;
            }
        };

        Question question4 = new MultipleQuestion<>(mg4
                , validationAnswer4
                , "Cargos existentes na T.I"
                , R.layout.layout_question_4
                , options2);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        Survey survey = new Survey(questions);
        survey.start(this);


    }
}
