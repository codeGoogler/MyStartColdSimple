package com.yyh.cold;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/6 0006.V
 *
 * http://blog.csdn.net/laizuling/article/details/51162011
 */

public class HeartMapView extends View{
    private Context context;
    private int lineColor =0;//折现颜色
    private int frameColr = 0;//边框颜色
    private int bgColor = 0;//底部背景颜色
    private int gridviewColor = 0;//小方格颜色
    private int mWidth;
    private int mheight;
    private Paint linePaint;
    private Paint framePaint;
    private Paint gridViewPaint ;
    private Paint pointPaint;
    private Path mPath;
    private int mHorientationNum = 12;
    private int mVertcalNum = 20;
    private float perHorieatationUnit= 0;
    private float perVertiacalUnit= 0;
    private int paddingLeft = 10;
    public HeartMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyHeartMapView);
        if(typedArray != null){
            lineColor = typedArray.getColor(R.styleable.MyHeartMapView_lineColor, ContextCompat.getColor(context,R.color.yello_deep));
            frameColr = typedArray.getColor(R.styleable.MyHeartMapView_frameColor, ContextCompat.getColor(context,R.color.white));
            bgColor = typedArray.getColor(R.styleable.MyHeartMapView_bgColor, ContextCompat.getColor(context,R.color.black));
            gridviewColor = typedArray.getColor(R.styleable.MyHeartMapView_gridviewColor, ContextCompat.getColor(context,R.color.green));
            typedArray.recycle();
        }
        initDatas();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpect = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpect = MeasureSpec.getMode(heightMeasureSpec);
        if(widthSpect  == MeasureSpec.UNSPECIFIED){
            mWidth  = DensityUtil.getScreenIntWidth(context);
        }else{
            mWidth = MeasureSpec.getSize(widthMeasureSpec);
        }
        if(heightSpect  == MeasureSpec.UNSPECIFIED){
            mheight  = DensityUtil.getScreenIntHeight(context);
        }else{
            mheight  =  MeasureSpec.getSize(heightMeasureSpec);
        }
        setMeasuredDimension(mWidth,mheight);
        perHorieatationUnit = (mWidth) / (1 + mHorientationNum);
        perVertiacalUnit = (mheight) / (1 + mVertcalNum);
        LogUtil.i("yyh",mWidth+"--------------" + MeasureSpec.getSize(heightMeasureSpec));
        LogUtil.i("yyh",MeasureSpec.getSize(widthMeasureSpec)+"--------------" +MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawColor(bgColor);
//        drawBottomLinePoint(canvas);
//        drawCubicLineT02(canvas);
//        canvas.restore();
    }

    private void drawBottomLinePoint(Canvas canvas) {

        float dX2 = 0;
        float dY1 = 10;
        float dY2 = mheight - 10;
        for (int i = 0; i <mHorientationNum; i++) {
            dX2+=perHorieatationUnit;
            canvas.drawCircle(dX2,dY2,5,framePaint);
            canvas.drawLine(dX2,dY1,dX2,dY2,linePaint);
            LogUtil.i("yyh",i+"-------dX2:  " +dX2);
        }
        float dyy1 = 0;
        float dyy = mWidth - 10;
        for (int j = 0; j < mVertcalNum; j++) {
            dyy1 += perVertiacalUnit;
            LogUtil.i("yyh",j+"----------dyy1:  " +dyy1);
            canvas.drawLine(0,dyy1,dyy,dyy1,linePaint);
        }
    }

    private void drawCubicLineT02(Canvas canvas) {
        mPath.moveTo(100, 100);
        canvas.drawPoint(100,100,pointPaint);
        canvas.drawPoint(100,500,pointPaint);
        canvas.drawPoint(300,100,pointPaint);
        canvas.drawPoint(600,500,pointPaint);
        mPath.cubicTo(100, 500, 300, 100, 400, 500);
        canvas.drawPath(mPath,linePaint);

        //mCurvePath.cubicTo((endPointX + lastPointX) / 2, lastPointY, (lastPointX + endPointX) / 2, endPointY, endPointX, endPointY);
    }


    private void initDatas(){
        pointPaint = new Paint();
        pointPaint.setColor(ContextCompat.getColor(context,R.color.red));
        pointPaint.setAntiAlias(true);
        pointPaint.setStyle(Paint.Style.STROKE);
        pointPaint.setStrokeWidth(9);
        pointPaint.setDither(true);

        linePaint = new Paint();
        linePaint.setColor(lineColor);
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(1);
        linePaint.setDither(true);

        framePaint = new Paint();
        framePaint.setColor(lineColor);
        framePaint.setAntiAlias(true);
        framePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        framePaint.setStrokeWidth(2);
        framePaint.setDither(true);

        gridViewPaint = new Paint();
        gridViewPaint.setColor(lineColor);
        gridViewPaint.setAntiAlias(true);
        gridViewPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        gridViewPaint.setStrokeWidth(2);
        gridViewPaint.setDither(true);


        mPath = new Path();
    }
}
