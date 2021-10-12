package com.example.thinklydemo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thinklydemo.Activity.ProductActivity;
import com.example.thinklydemo.R;
import com.example.thinklydemo.helper.QuestionsResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SubProductApdapter extends RecyclerView.Adapter<SubProductApdapter.ViewHolder> {

    public static Object ViewHolder;
    private Context mContext;
    private ArrayList<QuestionsResponse.Categories> data;
    Bitmap bitmap = null;



    public SubProductApdapter(Context context,  ArrayList<QuestionsResponse.Categories> categories) {
        this.mContext = context;
        this.data = categories;

    }


    @Override
    public SubProductApdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        SubProductApdapter.ViewHolder viewHolder = null;


        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.category_item, parent, false);
            viewHolder = new SubProductApdapter.ViewHolder(view);
            view.setTag(viewHolder);
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubProductApdapter.ViewHolder holder, int position) {

        holder.txt_name.setText(data.get(position).getCategoryName());
        holder.txt_description.setText(data.get(position).getProductCategoryDescription()+".....");

        String urll="https://lambda.sqyrewards.com/captainFarm/"+data.get(position).getCategoryImg();



            Picasso.with(mContext)
                    .load(urll)
                    .into(holder.image);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name,txt_description;
        public ImageView image;



        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();


                    Intent intent=new Intent(mContext, ProductActivity.class);
                    intent.putExtra("category_id",data.get(itemPosition).getId());
                    intent.putExtra("category_dec",data.get(itemPosition).getProductCategoryDescription());
                    intent.putExtra("category_url",data.get(itemPosition).getCategoryImg());
                    intent.putExtra("category_name",data.get(itemPosition).getCategoryName());
                    mContext.startActivity(intent);
                    ((Activity)mContext).finish();

                }
            });


        }



    }



}
