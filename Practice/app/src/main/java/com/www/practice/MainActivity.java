package com.www.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.daimajia.swipe.util.Attributes;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.www.practice.databinding.ActivityMainBinding;

import java.util.ArrayList;

import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ConstraintLayout layout;
    ArrayList<viewmodel> values= new ArrayList<>();
    String title[]={"Landscape1","Landscape2","Landscape3","Landscape4","Landscape5","Landscape1","Landscape2","Landscape3","Landscape4","Landscape5","Landscape1","Landscape2","Landscape3","Landscape4","Landscape5"};
    int mainimg[]={R.drawable.i5,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i5,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i5,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5};
    int delete[]={R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete,R.drawable.delete};
    int more[]={R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,
    R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,
            R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp,
            R.drawable.ic_more_vert_black_24dp,R.drawable.ic_more_vert_black_24dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        for(int i=0;i<mainimg.length;i++){
            viewmodel viewmodel=new viewmodel(mainimg[i],delete[i],more[i],title[i]);
            values.add(viewmodel);
        }


        binding.recycler1.setLayoutManager(new LinearLayoutManager(this));
        adapter adapter=new adapter(this,values);


        binding.recycler1.setAdapter(adapter);

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.close.setVisibility(View.GONE);
                binding.layout.setVisibility(View.VISIBLE);
                binding.layout.setBackground(new ColorDrawable(Color.argb(80,0,0,0)));

                binding.close2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.close.setVisibility(View.VISIBLE);
                        binding.layout.setVisibility(View.GONE);
                        binding.layout.setBackground(new ColorDrawable(Color.argb(00,0,0,0)));

//                        binding.frame.setBackground(new ColorDrawable(Color.alpha(0)));
                    }
                });

            }
        });

        //bottom sheet dialog:have to define definite height
//        binding.close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
//                bottomSheetDialog.setContentView(R.layout.dialog_bottom);
//                layout= bottomSheetDialog.findViewById(R.id.layout);
//                bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                bottomSheetDialog.setCanceledOnTouchOutside(false);
////                bottomBinding.close2.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        bottomSheetDialog.dismiss();
////                    }
////                });
//                bottomSheetDialog.show();
//            }
//        });


    }
}
