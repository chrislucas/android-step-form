package lib.view.stepform.action;

public interface QuestionCallback {
    void onStart();
    void whenPassing(int nQuestion);
    void whenSelecting(int nQuestion);
    void atTheEnd();
}
