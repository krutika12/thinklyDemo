package com.example.thinklydemo.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.thinklydemo.Fragment.FruitFragment;
import com.example.thinklydemo.Fragment.VegetableFragment;

public class ViewPagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public VegetableFragment frag1;
    public FruitFragment frag2;

    Context context;


    public ViewPagerAdapter(FragmentManager supportFragmentManager, int tabCount, Context context) {
        super(supportFragmentManager);
        this.mNumOfTabs=tabCount;
        this.context=context;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                //BlankFragment frag1=new BlankFragment();
                frag1 = new VegetableFragment(context);
                frag1.setIndex(0);
                return frag1;
            case 1:
                frag2 = new FruitFragment(context);
                frag2.setIndex(1);
                return frag2;

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
