package com.www.tabbartry;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class home_fragment extends Fragment {


    public home_fragment() {
        // Required empty public constructor
    }
public TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_fragment, container, false);
//       textView=view.findViewById(R.id.tv);
//       textView.setText(getArguments().getString("message"));
       return view;
    }

}
