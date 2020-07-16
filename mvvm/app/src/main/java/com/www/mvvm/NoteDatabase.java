package com.www.mvvm;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = note.class,version=1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    //this class will be used to use function that is defined in the notedao class i.e. insertion or deletion
    //by defining in the repositry repositry choose defined the api to choose from database or server.

    public abstract notedao noteDao();

    public static synchronized  NoteDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)     //this is added for creating first time database by calling callbback funtion
                    .build();
        }
        return instance;
    }

    // a callback fundtion for createing the first time database or opening it everytime

    public static RoomDatabase.Callback roomcallback= new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {

            super.onCreate(db);
            new PopulatedAsynctask(instance).execute();
        }
    };
// Asynctask has to created for this also
    private static class PopulatedAsynctask extends AsyncTask<Void,Void,Void>{
        private notedao notedao;

    public PopulatedAsynctask(NoteDatabase db) {
        notedao = db.noteDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
       notedao.insert(new note("Title 1","Description 1",1));
        notedao.insert(new note("Title 2","Description 2",2));
        notedao.insert(new note("Title 3","Description 3",3));

        return null;
    }
}

}
