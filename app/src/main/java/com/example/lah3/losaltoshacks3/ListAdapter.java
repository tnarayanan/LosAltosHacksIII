package com.example.lah3.losaltoshacks3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by praneethguduguntla on 3/24/18.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mDataSource;
    private String[] subTitle;

    public ListAdapter(Context context, String[] items, String[] subtitles) {
        mContext = context;
        mDataSource = items;
        subTitle=subtitles;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.length;
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource[(position)];
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_ui, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(R.id.task_list_title);

// Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(R.id.task_list_subtitle);

// Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(R.id.list_detail);

// Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(R.id.task_thumbnail);


        String title  = mDataSource[position];
        String subtitle = subTitle[position];
        titleTextView.setText(title);
        subtitleTextView.setText(subtitle);

        //thumbnailImageView.setImageDrawable(convertView.getResources().getDrawable(R.drawable.ic_action_compose));


        return rowView;


    }



}
