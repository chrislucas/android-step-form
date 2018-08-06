package br.com.xplorer.stepform;


import lib.view.stepform.action.SurveyCallback;

public class DefaultSurveyCallback implements SurveyCallback {

    public interface AccessUI {
        void beforeStart();
        void atTheEnd();
    }

    private static AccessUI accessUI;

    public DefaultSurveyCallback(AccessUI accessUI) {
        DefaultSurveyCallback.accessUI = accessUI;
    }

    @Override
    public void beforeStart() {
        if (accessUI != null)
            accessUI.beforeStart();
    }

    @Override
    public void atTheEnd() {
        if (accessUI != null) {
            accessUI.atTheEnd();
        }
    }

    public void destroyContext() {
        DefaultSurveyCallback.accessUI = null;
    }
}
