package com.www.mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private notedao notedao;
    private LiveData<List<note>> allnotes;

    public NoteRepository(Application application) {
        NoteDatabase database= NoteDatabase.getInstance(application);
        notedao = database.noteDao();
        allnotes= notedao.getallnote();
    }

    public void insert(note note){
   new InsertNoteAsynctask(notedao).execute(note);
    }
    public void update(note note){
        new UpdateNoteAsynctask(notedao).execute(note);

    }
    public void delete(note note){
        new DeleteNoteAsynctask(notedao).execute(note);

    }

    public void deleteallnotes(){
        new DeleteAllNoteAsynctask(notedao).execute();

    }


    public LiveData<List<note>> getAllnotes(){
        return allnotes;
    }


    //for inserting function
    private static class InsertNoteAsynctask extends AsyncTask<note,Void,Void>{

        private notedao notedao;
        private InsertNoteAsynctask(notedao notedao){
            this.notedao=notedao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            notedao.insert(notes[0]);
            return null;
        }
    }

    //for updating function
    private static class UpdateNoteAsynctask extends AsyncTask<note,Void,Void>{

        private notedao notedao;
        private UpdateNoteAsynctask(notedao notedao){
            this.notedao=notedao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            notedao.udate(notes[0]);
            return null;
        }
    }

    //for deleting function
    private static class DeleteNoteAsynctask extends AsyncTask<note,Void,Void>{

        private notedao notedao;
        private DeleteNoteAsynctask(notedao notedao){
            this.notedao=notedao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            notedao.delete(notes[0]);
            return null;
        }
    }

    //for deleting all notes
    private static class DeleteAllNoteAsynctask extends AsyncTask<note,Void,Void>{

        private notedao notedao;
        private DeleteAllNoteAsynctask(notedao notedao){
            this.notedao=notedao;
        }

        @Override
        protected Void doInBackground(note... notes) {
            notedao.deleteall();
            return null;
        }
    }
}
