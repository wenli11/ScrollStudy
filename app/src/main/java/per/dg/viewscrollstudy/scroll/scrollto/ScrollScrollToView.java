package per.dg.viewscrollstudy.scroll.scrollto;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

import per.dg.viewscrollstudy.scroll.CustomScrollView;

public class ScrollScrollToView extends CustomScrollView {

    public ScrollScrollToView(Context context) {
        super(context);
    }

    public ScrollScrollToView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollScrollToView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void scrollMethed(int offX, int offY) {
        scrollTo(getScrollX() + offX, getScrollY() + offY);
    }
}
