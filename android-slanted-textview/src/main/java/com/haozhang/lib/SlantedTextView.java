package com.haozhang.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author HaoZhang
 */
public class SlantedTextView extends View {

    public static final int MODE_LEFT = 0;
    public static final int MODE_RIGHT = 1;
    public static final int MODE_LEFT_BOTTOM = 2;
    public static final int MODE_RIGHT_BOTTOM = 3;
    public static final int MODE_LEFT_TRIANGLE = 4;
    public static final int MODE_RIGHT_TRIANGLE = 5;
    public static final int MODE_LEFT_BOTTOM_TRIANGLE = 6;
    public static final int MODE_RIGHT_BOTTOM_TRIANGLE = 7;

    private Paint mPaint;
    private TextPaint mTextPaint;
    private float mSlantedLength = 40;
    private float mTextSize = 16;
    private int mSlantedBackgroundColor = Color.TRANSPARENT;
    private int mTextColor = Color.WHITE;
    private String mSlantedText = "";
    private int mMode = MODE_LEFT;

    public SlantedTextView(Context context) {
        this(context, null);
    }

    public SlantedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SlantedTextView);

        mTextSize = array.getDimension(R.styleable.SlantedTextView_slantedTextSize, mTextSize);
        mTextColor = array.getColor(R.styleable.SlantedTextView_slantedTextColor, mTextColor);
        mSlantedLength = array.getDimension(R.styleable.SlantedTextView_slantedLength, mSlantedLength);
        mSlantedBackgroundColor = array.getColor(R.styleable.SlantedTextView_slantedBackgroundColor, mSlantedBackgroundColor);

        if (array.hasValue(R.styleable.SlantedTextView_slantedText)) {
            mSlantedText = array.getString(R.styleable.SlantedTextView_slantedText);
        }

        if (array.hasValue(R.styleable.SlantedTextView_slantedMode)) {
            mMode = array.getInt(R.styleable.SlantedTextView_slantedMode, 0);
        }
        array.recycle();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        mPaint.setAntiAlias(true);
        mPaint.setColor(mSlantedBackgroundColor);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawText(canvas);
    }


    private void drawBackground(Canvas canvas) {
        Path path = new Path();
        int w = getWidth();
        int h = getHeight();

        if (w != h) throw new IllegalStateException("SlantedTextView's width must equal to height");

        if (mMode == 0) {
            path.lineTo(w, h);
            path.lineTo(w, h - mSlantedLength);
            path.lineTo(mSlantedLength, 0);
        } else {
            path.moveTo(w, 0);
            path.lineTo(0, h);
            path.lineTo(0, h - mSlantedLength);
            path.lineTo(w - mSlantedLength, 0);
        }
        path.close();
        canvas.drawPath(path, mPaint);

        canvas.save();
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float textBaseY = getHeight() - (getHeight() - fontHeight) / 2 - fontMetrics.bottom;
        double offset = mSlantedLength / 4 - 1;
        float toY = (float) (textBaseY - offset);
        int angle = 45;
        if (mMode == 1) {
            angle = -45;
            offset = -offset;
        }
        float toX = (float) (getWidth() / 2 + offset);
        canvas.rotate(angle, toX, toY);
        canvas.drawText(mSlantedText, toX, toY, mTextPaint);
    }

    public SlantedTextView setText(String str) {
        mSlantedText = str;
        postInvalidate();
        return this;
    }

    public SlantedTextView setText(int res) {
        String str = getResources().getString(res);
        if (!TextUtils.isEmpty(str)) {
            setText(str);
        }
        return this;
    }

    public String getText() {
        return mSlantedText;
    }

    public SlantedTextView setSlantedBackgroundColor(int color) {
        mSlantedBackgroundColor = color;
        mPaint.setColor(mSlantedBackgroundColor);
        postInvalidate();
        return this;
    }

    public SlantedTextView setTextColor(int color) {
        mTextColor = color;
        mTextPaint.setColor(mTextColor);
        postInvalidate();
        return this;
    }

    /**
     * @param mode :
     * SlantedTextView.MODE_LEFT : top left
     * SlantedTextView.MODE_RIGHT :top right
     * @return this
     */
    public SlantedTextView setMode(int mode) {
        this.mMode = mode;
        postInvalidate();
        return this;
    }

    public int getMode() {
        return mMode;
    }

    public SlantedTextView setTextSize(int size) {
        this.mTextSize = size;
        mPaint.setTextSize(mTextSize);
        postInvalidate();
        return this;
    }

    /**
     * set slanted space length
     * @param length
     * @return this
     */
    public SlantedTextView setSlantedLength(int length) {
        mSlantedLength = length;
        postInvalidate();
        return this;
    }

}
