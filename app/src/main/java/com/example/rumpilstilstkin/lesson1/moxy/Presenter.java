package com.example.rumpilstilstkin.lesson1.moxy;


import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.rumpilstilstkin.lesson1.R;

@InjectViewState
public class Presenter extends MvpPresenter<MoxyExampleView> {

    private Model mModel;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mModel = new Model();
        Log.d("Dto", "first attach");
    }

    @Override
    public void attachView(MoxyExampleView view) {
        super.attachView(view);
        Log.d("Dto", "attach view");
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public int updateData(int modelElementIndex){
        int newModelValue = calcNewModelValue(modelElementIndex);
        mModel.setElementValueAtIndex(modelElementIndex, newModelValue);
        return newModelValue;
    }

}
