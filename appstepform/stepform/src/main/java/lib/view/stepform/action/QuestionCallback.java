package lib.view.stepform.action;

public interface QuestionCallback {
    void onStart();
    void atTheEnd();
    boolean validateWhenPassing(int nQuestion);
    void whenSelecting(int nQuestion);
}
