package com.example.carlt.gluebet;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;


public class RegistrationActivity extends AppCompatActivity {

    private Integer mYear, mMonth, mDay;
    private  DatePickerDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final Calendar c = Calendar.getInstance();
        final EditText dobEditText = (EditText) findViewById(R.id.EditTextDOBRegistration);
        if (mYear == null) {
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
        }
        dateDialog = new DatePickerDialog(this,R.style.DateDialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                dobEditText.setText(String.format("%02d",day) + "/" + String.format("%02d",(month + 1)) + "/" + year);
            }
        }, mYear, mMonth, mDay);

    }

    private boolean errorCheckFirstNameField(){
        String regexPattern = "[a-zA-Z ]+";
        final EditText t = (EditText) findViewById(R.id.EditTextFirstNameRegistration);
        if (t.getText().toString().matches("")){
            t.setError("Field cannot be empty");
            return false;
        } else if (! t.getText().toString().matches(regexPattern)){
            t.setError(("Please only use letters"));
            return false;
        } else{
            return true;
        }
    }

    private boolean errorCheckLastNameField(){
        String regexPattern = "[a-zA-Z ]+";
        final EditText t = (EditText) findViewById(R.id.EditTextLastNameRegistration);
        if (t.getText().toString().matches("")){
            t.setError("Field cannot be empty");
            return false;
        } else if (! t.getText().toString().matches(regexPattern)){
            t.setError(("Please only use letters"));
            return false;
        } else{
            return true;
        }
    }

    private boolean errorCheckEmailField(){
        String regexPattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        final EditText t = (EditText) findViewById(R.id.EditTextEmailRegistration);
        if (t.getText().toString().matches("")){
            t.setError("Field cannot be empty");
            return false;
        } else if (! t.getText().toString().matches(regexPattern)){
            t.setError(("Please use a valid Email Address"));
            return false;
        } else{
            return true;
        }
    }

    private boolean errorCheckPasswordField(){
        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{7,}$";
        final EditText t = (EditText) findViewById(R.id.EditTextPasswordRegistration);
        if (t.getText().toString().matches("")){
            t.setError("Field cannot be empty");
            return false;
        } else if (! t.getText().toString().matches(regexPattern)){
            t.setError(("Password must contain at least 7 characters and at least 1 number"));
            return false;
        } else{
            return true;
        }
    }

    private boolean errorCheckDOBField(){
        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{7,}$";
        final EditText t = (EditText) findViewById(R.id.EditTextDOBRegistration);
        if (t.getText().toString().matches("")){
            t.setError("Field cannot be empty");
            return false;
        } else if (! t.getText().toString().matches(regexPattern)){
            t.setError(("Password must contain at least 7 characters and at least 1 number"));
            return false;
        } else{
            return true;
        }
    }




    private boolean errorCheck(){
        if (errorCheckFirstNameField() && errorCheckLastNameField() && errorCheckEmailField() &&errorCheckPasswordField()){
            return true;
        }
        return false;
    }

    public void submitDetails(View view){
        errorCheck();
    }

    public void setDate(View view){
        dateDialog.show();
    }

}
