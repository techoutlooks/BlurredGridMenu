package com.goka.blurredgridmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by katsuyagoto on 2014/03/05.
 */
public class SquaredImageView extends ImageView {

    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_BORDER_RADIUS = 0;
    private static final int DEFAULT_BORDER_COLOR = Color.BLACK;
    private static final int DEFAULT_FILL_COLOR = Color.TRANSPARENT;

    private int mBorderColor = DEFAULT_BORDER_COLOR;
    private int mBorderWidth = DEFAULT_BORDER_WIDTH;
    private int mBorderRadius = DEFAULT_BORDER_RADIUS;
    private int mFillColor = DEFAULT_FILL_COLOR;

    public SquaredImageView(Context context) {
        super(context);
    }

    public SquaredImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SquaredImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SquaredImageView,
                defStyle, 0);

        mBorderWidth = a.getDimensionPixelSize(R.styleable.SquaredImageView_borderWidth, DEFAULT_BORDER_WIDTH);
        mBorderRadius = a.getDimensionPixelSize(R.styleable.SquaredImageView_borderRadius, DEFAULT_BORDER_RADIUS);
        mBorderColor = a.getColor(R.styleable.SquaredImageView_borderColor, DEFAULT_BORDER_COLOR);
        mFillColor = a.getColor(R.styleable.SquaredImageView_fillColor, DEFAULT_FILL_COLOR);

        a.recycle();

        //init();
    }

    public void setFillColor(int color) {
        mFillColor = color;
        SquaredImageView sqView = (SquaredImageView) findViewById(R.id.item_grid_icon);
        sqView.setFillColor(0x33ffffff);
        sqView.invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}