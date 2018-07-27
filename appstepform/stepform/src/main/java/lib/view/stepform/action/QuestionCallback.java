package lib.view.stepform.action;

public interface QuestionCallback {
    void onStart();
    boolean validateWhenPassing(int nQuestion);
    void whenSelecting(int nQuestion);
    void atTheEnd();
}
