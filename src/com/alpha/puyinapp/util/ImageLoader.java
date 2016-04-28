/**
 * 
 */
package com.alpha.puyinapp.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * @author Simon
 */
public class ImageLoader {
    public void showImageByAsyncTask(ImageView imageView, String url) {
        new MyAsyncTask(imageView).execute(url);
    }

    public Bitmap getBitmapFromURL(String urlString) {
        Bitmap bitmap;
        InputStream inputStream = null;
        try {
            URL url = new URL(urlString);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url
                        .openConnection();
                inputStream = new BufferedInputStream(
                        httpURLConnection.getInputStream());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = 3; // 将图片缩小倍
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                httpURLConnection.disconnect();// 释放资源
                return bitmap;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
        private final ImageView imageView;

        /*
         * (non-Javadoc)
         * 
         * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
         */
        public MyAsyncTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub
            return getBitmapFromURL(params[0]);
        }

        /*
         * (non-Javadoc)
         * 
         * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
         */
        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }
    }
}
