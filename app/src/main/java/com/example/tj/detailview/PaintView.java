package com.example.tj.detailview;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

/**
 * Created by TJ on 2016-06-08.
 */
public class PaintView extends View {

    private Paint paint;
    int color;
    int[] rgbColor;
    private int x;
    private int y;
    private int radius;
    String text;

    public PaintView(Context context, int color, int x, int y,int radius, String text) {
        super(context);
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.text = text;

        paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setAlpha(70);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextScaleX(3);
    }

    public PaintView(Context context, int[] rgb, int x, int y, int radius, String text) {
        super(context);
        rgbColor = new int[3];
        rgbColor = rgb;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.text = text;

        paint = new Paint();
        paint.setColor(Color.rgb(rgbColor[0],rgbColor[1],rgbColor[2]));
        paint.setAntiAlias(true);
        paint.setAlpha(80);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextScaleX(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,x,y,paint);
        canvas.drawCircle(x,y,radius,paint);
    }
}
