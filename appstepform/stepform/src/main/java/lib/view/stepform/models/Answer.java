package lib.view.stepform.models;



import lib.view.stepform.models.action.ValidationAnswer;


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

public abstract class Answer<T> {

    protected ValidationAnswer<T> validation;

    public Answer() {}

    public Answer(ValidationAnswer<T> validation) {
        this.validation = validation;
    }

    public ValidationAnswer<T> getValidation() {
        return validation;
    }

    protected abstract boolean validate();
}
