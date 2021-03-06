package com.example.android.presentor.help;

/**
 * Created by villa on 16/03/2018.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.presentor.R;

public class SliderAdapterDomotics extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterDomotics(Context context){
        this.context = context;
    }

    public  int[] slide_images = {

            R.drawable.domoticsslide1,
            R.drawable.domoticsslide2,
            R.drawable.domoticsslide3,
            R.drawable.domoticsslide4,
            R.drawable.domoticsslide5,
            R.drawable.domoticsslide6,
            R.drawable.domoticsslide7,
            R.drawable.domoticsslide8,
            R.drawable.domoticsslide9
    };

    public String[] slide_headings = {
            " ", " ", " ", " ", " ", " ", " ", " ", " "
    };

    public String [] slide_descs = {
            " ", " ", " ", " ", " ", " ", " ", " ", " "
    };


    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);
    }
}
