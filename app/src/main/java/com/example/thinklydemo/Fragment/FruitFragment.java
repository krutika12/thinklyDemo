package com.example.thinklydemo.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thinklydemo.Adapter.SubProductApdapter;
import com.example.thinklydemo.R;
import com.example.thinklydemo.common.CommonUtility;
import com.example.thinklydemo.helper.Api;
import com.example.thinklydemo.helper.QuestionsResponse;
import com.example.thinklydemo.helper.fpNetworkHelper;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FruitFragment extends Fragment {

    fpNetworkHelper apiInterface;

    RecyclerView list;
    LinearLayoutManager layoutManager;
    SubProductApdapter mAdapter;

    Context context;
    int index;


    public FruitFragment() {
        // Required empty public constructor
    }
    public FruitFragment(Context context) {
        this.context=context;
    }




    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        apiInterface = Api.getRetrofitInstance().create(fpNetworkHelper.class);
        View v= inflater.inflate(R.layout.fragment_fruit, container, false);
        list=v.findViewById(R.id.list);
        list.setHasFixedSize(true);

        getProductSubcategory();
        return v;
    }


    public void onDetach() {
        super.onDetach();

    }

    public void setIndex(int index) {
        this.index = index;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void getProductSubcategory() {
        try {
            if (CommonUtility.isInternetAvailable(context)) {
                CommonUtility.showCustomProgressDialog(context, "", getString(R.string.please_wait));



                Call<QuestionsResponse> questionsResponseCall = apiInterface.getproductsubcategory("6");

                questionsResponseCall.enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call, final Response<QuestionsResponse> response) {
                        Log.e("get subcategory",new Gson().toJson(response.body())+"");


                        if(response!=null && response.isSuccessful())
                        {

                            if (response.body().getStatus().equals("true")) {

                                CommonUtility.cancelProgressDialog();
                                list.setVisibility(View.VISIBLE);

                                CommonUtility.cancelProgressDialog();
                                mAdapter = new SubProductApdapter(context, response.body().getCategories());

                                layoutManager = new LinearLayoutManager(context);
                                list.setLayoutManager(layoutManager);
                                list.setAdapter(mAdapter);


                            }
                            else
                            {
                                CommonUtility.cancelProgressDialog();
                                Toast.makeText(context,"There is no data",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            CommonUtility.cancelProgressDialog();
                            Toast.makeText(context,"There seems some issue in the system, Please Try After Some Time",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                        CommonUtility.cancelProgressDialog();
                        Toast.makeText(context,"There seems some issue in the system, Please Try After Some Time",Toast.LENGTH_SHORT).show();
//                        Log.e("tag3", t.toString());
                    }
                });

            } else {
                Toast.makeText(context,"Please check internet connection",Toast.LENGTH_SHORT).show();

            }
        } catch (Exception ex) {
//            Log.e("tag4", ex.toString());
            CommonUtility.cancelProgressDialog();
            Toast.makeText(context,"There seems some issue in the system, Please Try After Some Time",Toast.LENGTH_SHORT).show();
            ex.printStackTrace();

        }
    }

}