package com.www.mvvm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //launch mode="single" in manifest file mentioned in mainactivity as it will rebound outside the oncreate method of mainactivity


    public static final int REQUEST_CODE = 1;
    public static final int EDITNOTE_CODE = 2;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;

    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addnote.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        //After .of activity or fragment is written which lifecycle has to be destroyed when it is finished and get noteviewmodel

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        //.observe is used to see the livecycle of the acytivity which is to be followed.Livedate is always aware of the livecycle
        noteViewModel.getAllnotes().observe(this, new Observer<List<note>>() {
            @Override
            public void onChanged(List<note> notes) {
                //update the recycler view
                adapter.setNotes(notes);

            }
        });
//for deleting by swapping right AND LEFT
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getposition(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Note is deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
//FOR UPDATING THE RECYCLER VIEW
        adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(note note) {
                Intent intent = new Intent(MainActivity.this, addnote.class);
                intent.putExtra(addnote.ID_KEY,note.getId());
                intent.putExtra(addnote.TITLE_KEY, note.getTitle());
                intent.putExtra(addnote.DESCRIPTION_KEY, note.getDescription());
                intent.putExtra(addnote.PRIORITY_KEY, note.getPriority());

                startActivityForResult(intent,EDITNOTE_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      // for insertion
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            String title = data.getStringExtra(addnote.TITLE_KEY);
            String description = data.getStringExtra(addnote.DESCRIPTION_KEY);
            int priority = data.getIntExtra(addnote.PRIORITY_KEY, 1);

            note note = new note(title, description, priority);
            noteViewModel.insert(note);

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();


        }
        // for updation
        else if(requestCode == EDITNOTE_CODE && resultCode == RESULT_OK){
            int id = data.getIntExtra(addnote.ID_KEY,-1);


            if(id==-1){
                Toast.makeText(this, "Note can't update", Toast.LENGTH_SHORT).show();
                return;
            }
            String title = data.getStringExtra(addnote.TITLE_KEY);
            String description = data.getStringExtra(addnote.DESCRIPTION_KEY);
            int priority = data.getIntExtra(addnote.PRIORITY_KEY, 1);


            note note = new note(title, description, priority);
            note.setId(id);
            noteViewModel.update(note);
            Toast.makeText(this, "Note is updated", Toast.LENGTH_SHORT).show();


        }
        else {
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_allnote:
                noteViewModel.deleteall();
                Toast.makeText(this, "All note deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
