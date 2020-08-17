package com.example.finalchallengeday1_project3_androidactivities_and_lifecycles;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    public static final int REQUEST_CODE = 3;

    private EditText name_eT;
    private EditText city_eT;
    private EditText mobileNumber_eT;

    private Button sendToSecondActivity;

    private TextView review_tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_eT = findViewById(R.id.name_editText);
        city_eT = findViewById(R.id.city_editText);
        mobileNumber_eT = findViewById(R.id.mobileNumber_editText);

        sendToSecondActivity = findViewById(R.id.sendToSecondActivity_btn);

        review_tV = findViewById(R.id.getReviews_textView);

        sendToSecondActivity.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        String name = name_eT.getText().toString();
        String city = city_eT.getText().toString();
        String mobileNumber = String.valueOf(mobileNumber_eT.getText());
        intent.putExtra("Key_Name",name);
        intent.putExtra("Key_City",city_eT.getText().toString());
        intent.putExtra("Key_MobileNumber",mobileNumber);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){

            assert data != null;
            String review = data.getStringExtra("Key_Feedback");
            review_tV.setText(review);
        }
    }
}