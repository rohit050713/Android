package com.www.mvvm;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class note {
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;
    public int priority;

    public note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
}
