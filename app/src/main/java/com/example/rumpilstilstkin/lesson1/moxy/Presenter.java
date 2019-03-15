package com.example.rumpilstilstkin.lesson1.moxy;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<MoxyView> {

    private static final int FIRST_MODEL_INDEX = 0;
    private static final int SECOND_MODEL_INDEX = 1;
    private static final int THIRD_MODEL_INDEX = 2;

    private ModelImpl mModel;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mModel = new ModelImpl();
        Log.d("Dto", "first attach");
    }

    @Override
    public void attachView(MoxyView view) {
        super.attachView(view);
        Log.d("Dto", "attach view");
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void changeValueFirst() {
        int newModelValue = calcNewModelValue(FIRST_MODEL_INDEX);
        mModel.setElementValueAtIndex(FIRST_MODEL_INDEX, newModelValue);
        getViewState().showValueFirst(newModelValue);
    }

    public void changeValueSecond() {
        int newModelValue = calcNewModelValue(SECOND_MODEL_INDEX);
        mModel.setElementValueAtIndex(SECOND_MODEL_INDEX, newModelValue);
        getViewState().showValueSecond(newModelValue);
    }

    public void changeValueThird() {
        int newModelValue = calcNewModelValue(THIRD_MODEL_INDEX);
        mModel.setElementValueAtIndex(THIRD_MODEL_INDEX, newModelValue);
        getViewState().showValueThird(newModelValue);
    }
}
