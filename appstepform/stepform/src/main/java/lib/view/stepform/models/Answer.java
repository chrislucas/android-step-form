package lib.view.stepform.models;



import android.os.Parcelable;


/**
 * Essa classe representa uma resposta de uma pergunta dentro do questionario.
 *
 * Uma resposta pode assumir qualquer tipo primitivo em java ou um Objeto, seja
 * ele um objeto dentre que representa uma instancia das classes existentes na API padrao do Java ou um objeto
 * criado por um desenvolvedor
 *
 * Uma pergunta pode ter 1 ou mais respostas
 *
 * */

public abstract class Answer<T> implements Parcelable {
    public Answer() {}


}
