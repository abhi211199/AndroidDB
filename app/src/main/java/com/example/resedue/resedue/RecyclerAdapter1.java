package com.example.resedue.resedue;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resedue.resedue.R;
import com.example.resedue.resedue.users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.MyHolder>{
    private List<users> list;
    private Context context;
    public RecyclerAdapter1(Context context,List<users> list) {
        this.list = list;
        this.context = context;
    }
    @Override

    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card1, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        final users mylist = list.get(position);
        holder.name.setText("Name  :  "+mylist.getName());
        holder.age.setText("Age  :  "+mylist.getAge());
        holder.time.setText("TimeStamp.  :  "+mylist.getTimestamp());
        //String url=mylist.getUrl();

//        set(url);
//        Toast.makeText(context, url, Toast.LENGTH_SHORT).show();



    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }
//@Override
//public int getItemCount() {
//    return list.size();
//}

    class MyHolder extends RecyclerView.ViewHolder {
        TextView age,name,time;
        CardView cardView ;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            age= (TextView) itemView.findViewById(R.id.age);
            time=(TextView) itemView.findViewById(R.id.time);
            cardView=(CardView)itemView.findViewById(R.id.card);


        }

    }

}
