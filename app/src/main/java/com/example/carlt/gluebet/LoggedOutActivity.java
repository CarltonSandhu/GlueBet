package com.example.carlt.gluebet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_out);
    }

    public void errorcheck(View view){
        EditText editText = (EditText) findViewById(R.id.EmailEdit);
        if (editText.getText().toString().equals("")){
            Toast.makeText(this,"FUCKING WRONG NIGGA",Toast.LENGTH_LONG).show();
        }
    }

}
