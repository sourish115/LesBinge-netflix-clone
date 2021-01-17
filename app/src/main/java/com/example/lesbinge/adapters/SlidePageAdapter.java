package com.example.lesbinge.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.lesbinge.models.SlideModel;

import java.util.List;

public class SlidePageAdapter extends PagerAdapter {

    private Context mContext;
    private List<SlideModel> mList;

    public SlidePageAdapter(Context mContext, List<SlideModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        super.destroyItem(container, position, object);
    }

}
