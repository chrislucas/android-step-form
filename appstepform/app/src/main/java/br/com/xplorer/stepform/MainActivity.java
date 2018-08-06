package br.com.xplorer.stepform;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import br.com.xplorer.stepform.models.City;
import br.com.xplorer.stepform.models.Role;
import br.com.xplorer.stepform.question.manager.Question1;
import br.com.xplorer.stepform.question.manager.Question3;
import br.com.xplorer.stepform.question.manager.Question2;
import br.com.xplorer.stepform.question.manager.Question4;
import br.com.xplorer.stepform.question.manager.Question5;
import lib.view.stepform.models.AbstractSurvey;
import lib.view.stepform.models.BooleanQuestion;
import lib.view.stepform.models.Question;
import lib.view.stepform.models.ModelSurvey;
import lib.view.stepform.models.options.Option;
import lib.view.stepform.views.fragments.FragmentSurvey;

public class MainActivity extends AppCompatActivity implements DefaultSurveyCallback.AccessUI {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new ArrayList<>();

        Question<String> question1 = new Question1("Questao 1", "Questao 1", R.layout.layout_question_1);
        BooleanQuestion question2 = new Question2("Questao 2", "Questao 2", R.layout.layout_question_2);

        List<Option<City>> optionsQuestion3 = new ArrayList<>();
        Option<City> option = new Option<>(new City(-1, "Selecione")
                , "Selecione");
        optionsQuestion3.add(option);
        option = new Option<>(new City(1
                , "Itaquaquecetuba"), "Itaquaquecetuba");
        optionsQuestion3.add(option);
        option = new Option<>(new City(2
                , "Poá"), "Poá");
        optionsQuestion3.add(option);
        option = new Option<>(new City(3
                , "Ferraz de Vasconcelos"), "Ferraz de Vasconcelos");
        optionsQuestion3.add(option);
        Question<City> question3 = new Question3( "Questao 3", "Questao 3"
                , R.layout.layout_question_3, optionsQuestion3);

        List<Option<Role>> optionsQuestion4 = new ArrayList<>();
        optionsQuestion4.add(new Option<>(new Role(1
                , "Engenheiro de Software"), "Engenheiro de Software"));
        optionsQuestion4.add(new Option<>(new Role(2
                , "Analista de Sistemas"), "Analista de Sistemas"));
        optionsQuestion4.add(new Option<>(new Role(3
                , "Engenheiro de Hardware"), "Engenheiro de Hardware"));
        optionsQuestion4.add(new Option<>(new Role(4
                , "Analista de Redes"), "Analista de Redes"));
        optionsQuestion4.add(new Option<>(new Role(5
                , "Técnico de Redes"), "Técnico de Redes"));
        Question<Role> question4 = new Question4("Questão 4", "Cargos existentes na T.I - Questão 4"
                , R.layout.layout_question_4, optionsQuestion4);

        List<Option<Role>> optionsQuestion5 = new ArrayList<>();
        optionsQuestion5.add(new Option<>(new Role(1
                , "Engenheiro de Software"), "Engenheiro de Software"));
        optionsQuestion5.add(new Option<>(new Role(2
                , "Analista de Sistemas"), "Analista de Sistemas"));
        optionsQuestion5.add(new Option<>(new Role(3
                , "Engenheiro de Hardware"), "Engenheiro de Hardware"));
        Question<Role> question5 = new Question5("Questão 5 - Aptidão Profissional"
                , "Questão 5", R.layout.layout_question_5, optionsQuestion5);


        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        ModelSurvey modelSurvey = new ModelSurvey(this, questions
                , new DefaultSurveyCallback(this), R.id.local_insert_fragment);
        modelSurvey.start();
    }


    @Override
    public void beforeStart() {

    }

    @Override
    public void atTheEnd() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Finalizar Formulário");
        builder.setMessage("Deseja finalizar o formulário");
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        break;
                }
                dialog.dismiss();
            }
        };
        builder.setPositiveButton(lib.view.stepform.R.string.yes, onClickListener);
        builder.setNegativeButton(lib.view.stepform.R.string.no, onClickListener);
        AlertDialog alertDialog = builder.create();

        if (!isFinishing() && ! alertDialog.isShowing()) {
            builder.create().show();
        }
    }
}
