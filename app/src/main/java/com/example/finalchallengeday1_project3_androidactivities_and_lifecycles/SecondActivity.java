package com.example.finalchallengeday1_project3_androidactivities_and_lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "SecondActivity";

    private TextView name;
    private TextView city;
    private TextView mobileNumber;

    private EditText feedback_eT;
    private Button sendToMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.receiveName_tv);
        city = findViewById(R.id.receiveCity_tv);
        mobileNumber = findViewById(R.id.receiveMobileNumber_tv);
        feedback_eT = findViewById(R.id.feedback_editText);
        sendToMainActivity = findViewById(R.id.sendToMainActivity_btn);

        sendToMainActivity.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String receive_name = bundle.getString("Key_Name");
            String receive_city = bundle.getString("Key_City");
            String receive_mobileNumber = bundle.getString("Key_MobileNumber");

            name.setText(receive_name);
            city.setText(receive_city);
            mobileNumber.setText(receive_mobileNumber);
            Log.d(TAG, "onCreate: "+receive_name+", "+receive_city+", "+receive_mobileNumber);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        String feedback = feedback_eT.getText().toString();
        intent.putExtra("Key_Feedback",feedback);
        setResult(RESULT_OK,intent);
        finish();
    }
}