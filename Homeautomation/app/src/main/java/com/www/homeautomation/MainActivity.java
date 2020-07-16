package com.www.homeautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.www.homeautomation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   ActivityMainBinding binding;
   FirebaseDatabase database= FirebaseDatabase.getInstance();
   DatabaseReference myref= database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

       myref.child("Toggle/switch").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               binding.switch1.setVisibility(View.VISIBLE);
               if(dataSnapshot.getValue().toString().equals("1")){
                   binding.switch1.isChecked();

                   binding.switch2.setVisibility(View.VISIBLE);
                   binding.switch3.setVisibility(View.VISIBLE);
                //for ac
                   myref.child("automation/AC").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           if(dataSnapshot.getValue().toString().equals("1")){
                               binding.switch2.isChecked();
                           }
                           else {
                               boolean checked2 = binding.switch2.isChecked();
                               checked2=false;
                           }
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError databaseError) {

                       }
                   });

                   myref.child("automation/light").addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           if(dataSnapshot.getValue().toString().equals("1")){
                               binding.switch3.isChecked();
                           }
                           else{
                               boolean checked3 = binding.switch2.isChecked();
                               checked3=false;                           }
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError databaseError) {

                       }
                   });
               }
               else{
                   boolean checked = binding.switch1.isChecked();
                   checked=false;

                   binding.switch2.setVisibility(View.GONE);
                   binding.switch3.setVisibility(View.GONE);
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

       //intent expected

      binding.switch1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(binding.switch1.isChecked()){
                  myref.child("Toggle/switch").setValue("1");

                  binding.switch2.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          if(binding.switch2.isChecked()){
                              myref.child("automation/AC").setValue("1");
                          }
                          else{
                              myref.child("automation/AC").setValue("0");
                          }
                      }
                  });

                  binding.switch3.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          if(binding.switch3.isChecked()){
                              myref.child("automation/light").setValue("1");
                          }
                          else{
                              myref.child("automation/light").setValue("0");
                          }
                      }
                  });
              }
              else{
                  myref.child("Toggle/switch").setValue("0");
              }
          }
      });

    }
}
