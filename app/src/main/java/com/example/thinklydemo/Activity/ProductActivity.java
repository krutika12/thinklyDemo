package com.example.thinklydemo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thinklydemo.R;
import com.squareup.picasso.Picasso;

public class ProductActivity extends Activity implements View.OnClickListener {

    String category_id,category_dec,category_url,category_name;
    ImageView image;
    TextView txt_title,txt_description,txt_heding_title;

    Button btn_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Toolbar toolbar = findViewById(R.id.title_bar);
        txt_heding_title = (TextView) toolbar.findViewById(R.id.txt_heding_title);
        txt_heding_title.setText("Category");

        Bundle bundle=getIntent().getExtras();
        category_id=bundle.getString("category_id");
        category_dec=bundle.getString("category_dec");
        category_url=bundle.getString("category_url");
        category_name=bundle.getString("category_name");

        txt_title=findViewById(R.id.txt_title);
        txt_description=findViewById(R.id.txt_description);
        image=findViewById(R.id.image);

        txt_title.setText(category_name);
        txt_description.setText(category_dec);
        String urll="https://lambda.sqyrewards.com/captainFarm/"+category_url;



        Picasso.with(this)
                .load(urll)
                .into(image);

        btn_edit=findViewById(R.id.btn_edit);

        btn_edit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(btn_edit==view)
        {

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(ProductActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

}