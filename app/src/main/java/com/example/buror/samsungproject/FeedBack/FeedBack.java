package com.example.buror.samsungproject.FeedBack;

import android.app.Application;
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
        collapsingToolbar.setTitle("Your Feedback");

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


    private boolean validateInput() { // Validate text input
        if (feedbackInputField.getText().toString().trim().length() == 0 && nameInputField.getText().toString().trim().length() == 0 && emailInputField.getText().toString().trim().length() == 0) {
            feedbackInputField.setError("Enter your feedback!");
            nameInputField.setError("Enter a valid name!");
            emailInputField.setError("Enter a valid email!");
            Toast.makeText(FeedBack.this, "Please fill in the required fields!", Toast.LENGTH_LONG).show();
            return false;
        } else {
            sendData();
            return true;
        }
    }

    private void sendData() { // Send feedback to Google Spreadsheet if text input is valid

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/") // Your spreadsheet URL
                .build();
        final SpreadsheetWebService spreadsheetWebService = retrofit.create(SpreadsheetWebService.class);

        String feedbackInput = feedbackInputField.getText().toString();
        String nameInput = nameInputField.getText().toString();
        String emailInput = emailInputField.getText().toString();

        Call<Void> feedbackCall = spreadsheetWebService.feedbackSend(feedbackInput, nameInput, emailInput);
        feedbackCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(FeedBack.this,"Your feedback was submitted!",Toast.LENGTH_LONG).show();
                // Clear all fields after submitting
                feedbackInputField.setText("");
                nameInputField.setText("");
                emailInputField.setText("");
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(FeedBack.this,"There was an error!",Toast.LENGTH_LONG).show();
            }
        });
    }

}
