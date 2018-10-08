package com.example.rumpilstilstkin.lesson1.moxy;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.rumpilstilstkin.lesson1.R;


public class MoxyMainActivity extends MvpAppCompatActivity
        implements MoxyExampleView, View.OnClickListener {

    @InjectPresenter
    Presenter presenter;

    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.btnCounter1);
        btnCounter2 = (Button) findViewById(R.id.btnCounter2);
        btnCounter3 = (Button) findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCounter1:
                setButtonText(1, presenter.updateData(0));
                break;
            case R.id.btnCounter2:
                setButtonText(2, presenter.updateData(1));
                break;
            case R.id.btnCounter3:
                setButtonText(3, presenter.updateData(2));
                break;
        }

    }

    @Override
    public void setButtonText(int btnIndex, int value) {
        switch (btnIndex) {
            case 1:
                btnCounter1.setText("Количество = " + value);
                break;
            case 2:
                btnCounter2.setText("Количество = " + value);
                break;
            case 3:
                btnCounter3.setText("Количество = " + value);
                break;
        }
    }
}
