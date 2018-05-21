package com.example.buror.samsungproject.FeedBack;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buror.samsungproject.R;
import com.r0adkll.slidr.Slidr;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FeedBack extends AppCompatActivity {

    private EditText feedbackInputField;
    private EditText nameInputField;
    private EditText emailInputField;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        collapsingToolbar =  findViewById(R.id.collapsing);
        collapsingToolbar.setTitle("Ваш отзыв");

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        feedbackInputField =  findViewById(R.id.feedback_input);
        nameInputField =  findViewById(R.id.name_input);
        emailInputField =  findViewById(R.id.email_input);

        findViewById(R.id.submit_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(validateInput()){
                            Toast.makeText(getApplicationContext(), "Спасибо за отзыв", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }
                    }
                }
        );
        Slidr.attach(this);
    }


    private boolean validateInput() {
        if (feedbackInputField.getText().toString().trim().length() == 0 && nameInputField.getText().toString().trim().length() == 0 && emailInputField.getText().toString().trim().length() == 0) {
            feedbackInputField.setError("Введите отзыв");
            nameInputField.setError("Введите ваше имя");
            emailInputField.setError("Введите вашу почту");
            Toast.makeText(FeedBack.this, "Пожалуйста, заполните все пункты", Toast.LENGTH_LONG).show();
            return false;
        } else {
            sendData();
            return true;
        }
    }

    private void sendData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();
        final SpreadsheetWebService spreadsheetWebService = retrofit.create(SpreadsheetWebService.class);

        String feedbackInput = feedbackInputField.getText().toString();
        String nameInput = nameInputField.getText().toString();
        String emailInput = emailInputField.getText().toString();

        Call<Void> feedbackCall = spreadsheetWebService.feedbackSend(feedbackInput, nameInput, emailInput);
        feedbackCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(FeedBack.this,"Ваш отзыв отправлен!",Toast.LENGTH_LONG).show();
                feedbackInputField.setText("");
                nameInputField.setText("");
                emailInputField.setText("");
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(FeedBack.this,"Упс... кажется где-то ошибка",Toast.LENGTH_LONG).show();
            }
        });
    }

}
