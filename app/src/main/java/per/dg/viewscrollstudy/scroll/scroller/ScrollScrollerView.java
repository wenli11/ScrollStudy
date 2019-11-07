package per.dg.viewscrollstudy.scroll.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ScrollScrollerView extends TextView {

    public ScrollScrollerView(Context context) {
        super(context);
    }

    public ScrollScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public ScrollScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Scroller mScroller;

    int oldX;
    int oldY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                oldX = (int) event.getRawX();
                oldY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                int nowX = (int) event.getRawX();
                int nowY = (int) event.getRawY();
                mScroller.startScroll(getScrollX(), getScrollY(), nowX-oldX, nowY-oldY);
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
