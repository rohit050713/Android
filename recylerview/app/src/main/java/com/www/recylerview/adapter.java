package com.www.recylerview;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.www.recylerview.model;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

private Context context;
    private ArrayList<model> values;


    public adapter(Context context, ArrayList<model> values) {
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.content_layout,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        model m= values.get(position);

        holder.tv1.setText(m.getTv1());

        holder.tv2.setText(m.getTv2());

        holder.iv1.setImageResource(m.getImages());

        holder.expandable_tv.setText(m.getExpandable_tv());

        holder.expandable_layout.setVisibility(View.GONE);

       //for the switch button functiontiong define in the onbind holder in the adapter
        holder.switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.switchCompat.isChecked()){
                    Toast.makeText(context, "Clicked on", Toast.LENGTH_SHORT).show();
                    //for the expandable recycler view
                    holder.expandable_layout.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast.makeText(context, "Clicked off", Toast.LENGTH_SHORT).show();
                    holder.expandable_layout.setVisibility(View.GONE);

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       public TextView tv1;
       public TextView tv2;
       private TextView expandable_tv;
       LinearLayout expandable_layout;
       public ImageView iv1;
        SwitchCompat switchCompat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            switchCompat=itemView.findViewById(R.id.toggle_button);

            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            iv1=itemView.findViewById(R.id.iv_1);
            expandable_tv=itemView.findViewById(R.id.expandable_tv);
            expandable_layout=itemView.findViewById(R.id.expandable_layout);
        }
    }

}
