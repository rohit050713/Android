package com.www.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


//this class has the superclass which is it is extending i.e. androidviewmodel
public class NoteViewModel extends AndroidViewModel {
    NoteRepository noteRepository;
    LiveData<List<note>> allnotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository= new NoteRepository(application);
        allnotes=noteRepository.getAllnotes();

    }

    public void insert(note note){
        noteRepository.insert(note);
    }
    public void update(note note){
        noteRepository.update(note);
    }
    public void delete(note note){
        noteRepository.delete(note);
    }
    public void deleteall(){
        noteRepository.deleteallnotes();
    }
    public LiveData<List<note>> getAllnotes(){
        return allnotes;
    }
}
