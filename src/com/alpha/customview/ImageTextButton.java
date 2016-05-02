/**
 * 
 */
package com.alpha.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

import com.alpha.puyinapp.R;

/**
 * @author Simon
 * @category自定义图片文字按钮 2016.5.2
 */
public class ImageTextButton extends Button {
    private Bitmap bitmap;
    private int resourceId = 0;

    /**
     * @param context
     */
    public ImageTextButton(Context context) {
        super(context, null);
        // TODO Auto-generated constructor stub
    }

    public ImageTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setClickable(true);
        resourceId = R.drawable.sort1;
        bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
    }

    public void setIcon(int resourceId) {
        this.bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        invalidate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.widget.TextView#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int x = (this.getMeasuredWidth() - bitmap.getWidth()) / 2;
        int y = 0;
        canvas.drawBitmap(bitmap, x, y, null);
        canvas.translate(0,
                (this.getMeasuredHeight() / 2) - (int) this.getTextSize());
        super.onDraw(canvas);
    }
}
