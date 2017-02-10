public class TestView extends View {
    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static final String TAG = "TestView";

    @Override
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(0, 0, getWidth(), getHeight());//画一个矩形
        Log.d(TAG, "onDraw: " + rect);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(DensityUtil.dip2px(20));
        textPaint.setStyle(Paint.Style.FILL);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        Log.d(TAG, "getWidth(): " + getWidth() + " getHeight() " + getHeight() / 2 + " top " + top + " bottom " + bottom);
        int baseLineY = (int) (getHeight() / 2 - top / 2 - bottom / 2);//基线中间点的y轴计算公式
        Log.d(TAG, "onDraw: " + baseLineY + " rect.centerY() " + rect.centerY());
        canvas.drawText("this is a test", getWidth() / 2, baseLineY/*getHeight() / 2*/, textPaint);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
         paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() > getWidth() ? getWidth() / 2 : getHeight() / 2, paint);
    }

}
