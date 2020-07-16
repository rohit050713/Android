package com.www.nav_bar;


import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {

public Button btn1;
public Button btn2;
public Button btn3;
public Button btn4;

    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);

        btn1=view.findViewById(R.id.login);
        btn2=view.findViewById(R.id.sign);

        btn3=view.findViewById(R.id.country);

        btn4=view.findViewById(R.id.pckage);

       btn1.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
              final Dialog dialog=new Dialog(getContext());
               dialog.setContentView(R.layout.login);
               ImageView img=dialog.findViewById(R.id.close);
               img.setOnClickListener(new OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });

               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
               dialog.setCancelable(false);
               dialog.show();
           }

       });
        return view;
    }






}
