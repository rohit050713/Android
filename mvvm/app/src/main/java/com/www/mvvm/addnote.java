package com.www.mvvm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class addnote extends AppCompatActivity {
    public static final String ID_KEY = "com.www.mvvm.ID_KEY";

    public static final String TITLE_KEY = "com.www.mvvm.TITLE_KEY";
    public static final String DESCRIPTION_KEY = "com.www.mvvm.DESCRIPTION_KEY";
    public static final String PRIORITY_KEY = "com.www.mvvm.PRIORITY";


    private EditText et_title;
    private EditText et_description;
    private NumberPicker et_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        et_title = findViewById(R.id.addnote_title);
        et_description = findViewById(R.id.addnote_description);
        et_picker = findViewById(R.id.number_picker);

        et_picker.setMinValue(1);
        et_picker.setMaxValue(10);
        //for leftcorner icon in the tool bar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        //for updating
        Intent intent = getIntent();
        if (intent.hasExtra(ID_KEY)) {
            setTitle("Edit Note");
            et_title.setText(intent.getStringExtra(TITLE_KEY));
            et_description.setText(intent.getStringExtra(DESCRIPTION_KEY));
            et_picker.setValue(intent.getIntExtra(PRIORITY_KEY, 1));
        } else {
            setTitle("Add Note");
        }

    }

    public void savenote() {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        int priority = et_picker.getValue();
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please input title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data1 = new Intent();
        data1.putExtra(TITLE_KEY, title);
        data1.putExtra(DESCRIPTION_KEY, description);
        data1.putExtra(PRIORITY_KEY, priority);
       //for checking the updating dont know exactly about it
        int id = getIntent().getIntExtra(ID_KEY, -1);
        if (id != -1) {
            data1.putExtra(ID_KEY, id);
        }
        setResult(RESULT_OK, data1);
        finish();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                savenote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
