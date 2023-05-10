package com.example.gambardicanvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public class MyCanvasView extends View {

    private Paint mPaint;
    private Path mPath;
    private int mDrawColor;
    private int mBackgroundColor;
    private Canvas mExtraCanvas;
    private Bitmap mExstraBitmap;
    private Rect mFrame;


    public MyCanvasView(Context context) {
        this(context, null);
    }

    public MyCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mBackgroundColor = ResourcesCompat.getColor(getResources(),
                R.color.opaque_orange, null);
        mDrawColor = ResourcesCompat.getColor(getResources(), R.color.opaque_yellow, null);

        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(mDrawColor);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mExstraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExstraBitmap);
        mExtraCanvas.drawColor(mBackgroundColor);

        int inset = 40;
        mFrame = new Rect(inset, inset, w-inset, h-inset);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExstraBitmap, 0, 0, null);
        canvas.drawRect(mFrame, mPaint);
    }
}
