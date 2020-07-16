package com.www.mvvm;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface notedao {

    @Insert
    void insert(note note);
    @Update
    void udate(note note);
    @Delete
    void delete(note note);

// click cltrl+B for seeing the functioning of @insert or @delete
    @Query("Delete From note_table")
     void deleteall();


    //this for getting all the data displaying on the recycler as soon as it is updated through the use of livedata
    @Query("Select * From note_table Order By priority DESC")
    LiveData<List<note>> getallnote();

// for connecting all this class of room such as note and notedao we have to create a new database
// java class which has superclass of roomdatabase and abstract method


}
