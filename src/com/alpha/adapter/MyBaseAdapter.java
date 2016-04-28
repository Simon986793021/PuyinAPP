/**
 * 
 */
package com.alpha.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alpha.puyinapp.R;
import com.alpha.puyinapp.util.ImageLoader;
import com.alpha.puyinapp.util.NewsBean;

/**
 * @author Simon
 */
public class MyBaseAdapter extends BaseAdapter {
    private final List<NewsBean> list;
    private final LayoutInflater layoutInflater;

    public MyBaseAdapter(Context context, List<NewsBean> list) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.widget.Adapter#getView(int, android.view.View,
     * android.view.ViewGroup)
     */
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Viewholder viewholder = null;
        if (convertView == null) {
            viewholder = new Viewholder();
            convertView = layoutInflater.inflate(R.layout.silver_listview_item,
                    null);
            viewholder.nameTextView = (TextView) convertView
                    .findViewById(R.id.tv_ordername);
            viewholder.priceTextView = (TextView) convertView
                    .findViewById(R.id.tv_orderprice);
            viewholder.saleTextView = (TextView) convertView
                    .findViewById(R.id.tv_sales);
            viewholder.pictureImageView = (ImageView) convertView
                    .findViewById(R.id.iv_orderimage);
            convertView.setTag(viewholder);

        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        String url = "http://www.puyinwang.com/ImagePool/image_pool/"
                + list.get(position).picture + ".jpg";

        viewholder.nameTextView.setText(list.get(position).name);
        viewholder.priceTextView.setText("￥" + list.get(position).price);
        viewholder.saleTextView.setText(list.get(position).sale + "人付款");
        viewholder.pictureImageView.setImageResource(R.drawable.silver1);
        new ImageLoader()
                .showImageByAsyncTask(viewholder.pictureImageView, url);
        return convertView;
    }

    class Viewholder {
        public TextView nameTextView;
        public TextView priceTextView;
        public TextView saleTextView;
        public ImageView pictureImageView;
    }
}
