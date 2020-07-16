package com.www.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern Password = Pattern.compile("^"+"(?=.*[a-z])"+"(?=.*[A-Z])"+"(?=.*[0-9])"+"(?=.*[!@#$%&*+])"+"(?=\\S+$)"+".{6,}"+"$");

    public EditText firstname;
    public EditText lastname;
    public EditText mail;
    public EditText phone;
    public EditText state;
    public EditText code;
    public EditText country;
    public EditText password;
    public EditText cnfpassword;


    public TextView tvfirstname;
    public TextView tvlastname;
    public TextView tvmail;
    public TextView tvphone;
    public TextView tvstate;
    public TextView tvcode;
    public TextView tvcountry;
    public TextView tvpassword;
    public TextView tvcnfpassword;
    public TextView tvcheck;

    public CheckBox terms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.et1);
        lastname = findViewById(R.id.et2);
        mail = findViewById(R.id.et3);
        phone = findViewById(R.id.et4);
        state = findViewById(R.id.et5);
        code = findViewById(R.id.et6);
        country = findViewById(R.id.et7);
        password = findViewById(R.id.et8);
        cnfpassword = findViewById(R.id.et9);

        terms=findViewById(R.id.checkBox);

        tvfirstname = findViewById(R.id.tv1);
        tvlastname = findViewById(R.id.tv2);
        tvmail = findViewById(R.id.tv3);
        tvphone = findViewById(R.id.tv4);
        tvstate = findViewById(R.id.tv5);
        tvcode = findViewById(R.id.tv6);
        tvcountry = findViewById(R.id.tv7);
        tvpassword = findViewById(R.id.tv8);
        tvcnfpassword = findViewById(R.id.tv9);

        tvcheck = findViewById(R.id.tv10);



     firstname.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String a = firstname.getText().toString();
             if (a.isEmpty()) {
                 tvfirstname.setVisibility(View.VISIBLE);
                 tvfirstname.setText("*Please input the first name.");

             }
             else{
                 tvfirstname.setVisibility(View.INVISIBLE);
             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     lastname.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String b = lastname.getText().toString();
             if (b.isEmpty()) {
                 tvlastname.setVisibility(View.VISIBLE);
                 tvlastname.setText("*Please input the last name.");

             }
             else{
                 tvlastname.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     mail.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String c = mail.getText().toString();
             if (c.isEmpty()) {
                 tvmail.setVisibility(View.VISIBLE);
                 tvmail.setText("*Please input the mail id.");

             }
             else if(!Patterns.EMAIL_ADDRESS.matcher(c).matches()){
                 tvmail.setVisibility(View.VISIBLE);
                 tvmail.setText("*Please input the valid email address.");

             }
             else{
                 tvmail.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     phone.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String d = phone.getText().toString();
             if (d.isEmpty()) {
                 tvphone.setVisibility(View.VISIBLE);
                 tvphone.setText("*Please input the phone number.");

             }
             else if(d.length() < 10){
                 tvphone.setVisibility(View.VISIBLE);
                 tvphone.setText("*Please input the valid phone number.");

             }
             else{
                 tvphone.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     state.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String e = state.getText().toString();
             if (e.isEmpty()) {
                 tvstate.setVisibility(View.VISIBLE);
                 tvstate.setText("*Please input the state name.");

             }
             else{
                 tvstate.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     code.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String f = code.getText().toString();
             if (f.isEmpty()) {
                 tvcode.setVisibility(View.VISIBLE);
                 tvcode.setText("*Please input the pin code.");

             }
             else if(f.length() < 6){
                 tvcode.setVisibility(View.VISIBLE);
                 tvcode.setText("*Please input the valid pin code.");

             }
             else{
                 tvcode.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });
     country.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String g = country.getText().toString();
             if (g.isEmpty()) {
                 tvcountry.setVisibility(View.VISIBLE);
                 tvcountry.setText("*Please input the country name.");

             }
             else{
                 tvcountry.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

     password.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String h = password.getText().toString();
             if (h.isEmpty()) {
                 tvpassword.setVisibility(View.VISIBLE);
                 tvpassword.setText("*Please input the password.");

             }
             else if(!Password.matcher(h).matches()){
                 tvpassword.setVisibility(View.VISIBLE);
                 tvpassword.setText("*Password is too weak.");

             }
             else{
                 tvpassword.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });
     cnfpassword.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             String h = password.getText().toString();
             String i = cnfpassword.getText().toString();
             if (i.isEmpty()) {
                 tvcnfpassword.setVisibility(View.VISIBLE);
                 tvcnfpassword.setText("*Please retype the password");

             }
             else if(!i.equals(h)){
                 tvcnfpassword.setVisibility(View.VISIBLE);
                 tvcnfpassword.setText("*Password not matched");

             }
             else{
                 tvcnfpassword.setVisibility(View.INVISIBLE);

             }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });

    }

    public void button(View view) {
        if(!validatefirstname() | !validatelastname() | !validatemail() | !validatephone() | !validatestate()
                | !validatecode() | !validatecountry() | !validatepassword() | !validatecnfpassword()  | !validatecheckbox()){
            return ;
        }
    }

    public boolean validatefirstname() {
        String a = firstname.getText().toString();
        if (a.isEmpty()) {
            tvfirstname.setVisibility(View.VISIBLE);
            tvfirstname.setText("*Please input the first name.");
            return false;
        }
        else{
            tvfirstname.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatelastname() {
        String b = lastname.getText().toString();
        if (b.isEmpty()) {
            tvlastname.setVisibility(View.VISIBLE);
            tvlastname.setText("*Please input the last name.");
            return false;
        }
        else{
            tvlastname.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatemail() {
        String c = mail.getText().toString();
        if (c.isEmpty()) {
            tvmail.setVisibility(View.VISIBLE);
            tvmail.setText("*Please input the mail id.");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(c).matches()){
            tvmail.setVisibility(View.VISIBLE);
            tvmail.setText("*Please input the valid email address.");
            return false;
        }
        else{
            tvmail.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatephone() {
        String d = phone.getText().toString();
        if (d.isEmpty()) {
            tvphone.setVisibility(View.VISIBLE);
            tvphone.setText("*Please input the phone number.");
            return false;
        }
        else if(d.length() < 10){
            tvphone.setVisibility(View.VISIBLE);
            tvphone.setText("*Please input the valid phone number.");
            return false;
        }
        else{
            tvphone.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatestate() {
        String e = state.getText().toString();
        if (e.isEmpty()) {
            tvstate.setVisibility(View.VISIBLE);
            tvstate.setText("*Please input the state name.");
            return false;
        }
        else{
            tvstate.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatecode() {
        String f = code.getText().toString();
        if (f.isEmpty()) {
            tvcode.setVisibility(View.VISIBLE);
            tvcode.setText("*Please input the pin code.");
            return false;
        }
        else if(f.length() < 6){
            tvcode.setVisibility(View.VISIBLE);
            tvcode.setText("*Please input the valid pin code.");
            return false;
        }
        else{
            tvcode.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatecountry() {
        String g = country.getText().toString();
        if (g.isEmpty()) {
            tvcountry.setVisibility(View.VISIBLE);
            tvcountry.setText("*Please input the country name.");
            return false;
        }
        else{
            tvcountry.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatepassword() {
        String h = password.getText().toString();
        if (h.isEmpty()) {
            tvpassword.setVisibility(View.VISIBLE);
            tvpassword.setText("*Please input the password.");
            return false;
        }
        else if(!Password.matcher(h).matches()){
            tvpassword.setVisibility(View.VISIBLE);
            tvpassword.setText("*Password is too weak.");
            return false;
        }
        else{
            tvpassword.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatecnfpassword() {
        String h = password.getText().toString();
        String i = cnfpassword.getText().toString();
        if (i.isEmpty()) {
            tvcnfpassword.setVisibility(View.VISIBLE);
            tvcnfpassword.setText("*Please retype the password");
            return false;
        }
        else if(!i.equals(h)){
            tvcnfpassword.setVisibility(View.VISIBLE);
            tvcnfpassword.setText("*Password not matched");
            return false;
        }
        else{
            tvcnfpassword.setVisibility(View.INVISIBLE);
            return true;
        }

    }

    public boolean validatecheckbox(){
        if(!terms.isChecked()){
            tvcheck.setVisibility(View.VISIBLE);
            tvcheck.setText("*Please accept the terms and condition");
            return false;
        }
        else{
            tvcheck.setVisibility(View.INVISIBLE);
            return true;
        }
    }
}

