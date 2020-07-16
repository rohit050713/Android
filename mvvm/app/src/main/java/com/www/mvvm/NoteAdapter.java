package com.www.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.*;
//note is behaving just like an model in the recycler view
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    List <note> notes= new ArrayList<>();
    OnItemClickListener listener;
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        note current_note=notes.get(position);
        holder.tv_title.setText(current_note.getTitle());
        holder.tv_description.setText(current_note.getDescription());
        holder.tv_priority.setText(String.valueOf(current_note.getPriority()));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<note> notes){
      this.notes=notes;
      notifyDataSetChanged();
    }
    public note getposition(int position){
       return notes.get(position);
    }

    class NoteHolder extends ViewHolder{
          private TextView tv_title;
          private TextView tv_description;
          private TextView tv_priority;


          public NoteHolder(@NonNull View itemView) {
              super(itemView);
              tv_title=itemView.findViewById(R.id.tv_title);
              tv_description=itemView.findViewById(R.id.tv_description);
              tv_priority=itemView.findViewById(R.id.tv_priority);
              itemView.setOnClickListener(new OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      int position= getAdapterPosition();
                      if(listener != null && position != RecyclerView.NO_POSITION) {
                          listener.onItemClick(notes.get(position));
                      }
                  }
              });
          }
      }
      //Recycler view dont have there on item click listener like list view so we have to create the on item click listener for the recycler view
      public interface OnItemClickListener{
        void onItemClick(note note);
      }
      public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
      }
}
