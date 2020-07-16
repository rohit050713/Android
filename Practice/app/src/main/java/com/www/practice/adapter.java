package com.www.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;

import static androidx.recyclerview.widget.ItemTouchHelper.LEFT;
import static androidx.recyclerview.widget.ItemTouchHelper.RIGHT;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    Context context;
    ArrayList<viewmodel> arrayList;

    public adapter(Context context, ArrayList<viewmodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
      viewmodel viewmodel= arrayList.get(position);
      holder.title.setText(viewmodel.getTv());
      holder.i1.setImageResource(viewmodel.getI1());
      holder.delete.setImageResource(viewmodel.getDelete());
      holder.more.setImageResource(viewmodel.getMore());


        holder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        //for left side icon
//        holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, holder.swipeLayout.findViewById(R.id.bottom_wrapper1));

        //for right side icon
        holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, holder.swipeLayout.findViewById(R.id.linear_layout));



        holder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      SwipeLayout swipeLayout;
       ImageView i1,delete,more;
       TextView title;
       LinearLayout linearLayout;
       RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            i1=itemView.findViewById(R.id.iv);
            delete=itemView.findViewById(R.id.delete);
            more=itemView.findViewById(R.id.more);
            title=itemView.findViewById(R.id.tv);
            linearLayout=itemView.findViewById(R.id.linear_layout);
            recyclerView=itemView.findViewById(R.id.recycler1);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);


        }

    }

}
