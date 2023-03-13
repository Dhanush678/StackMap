package com.example.stackmap;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class listadapter extends RecyclerView.Adapter<listadapter.ViewHolder> {

    list[] myMovieData;
    Context context;
    int position=0;

    public listadapter(list[] myMovieData, MainActivity activity) {
        this.myMovieData = myMovieData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final list myMovieDataList = myMovieData[position];
        holder.textViewName.setText(myMovieDataList.getMovieName());
        holder.textViewDate.setText(myMovieDataList.getMovieDate());
        holder.movieImage.setImageResource(myMovieDataList.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent;
                switch (position){
                    case 0:
                        intent =  new Intent(context, basicconcept.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent =  new Intent(context, array.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent =  new Intent(context, linkedlist.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent =  new Intent(context, stack.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent =  new Intent(context, queue.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent =  new Intent(context, tree.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent =  new Intent(context, graph.class);
                        context.startActivity(intent);
                        break;



                    default:
                        intent =  new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        break;
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return myMovieData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView textViewName;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textName);
            textViewDate = itemView.findViewById(R.id.textdate);

        }
    }

}
