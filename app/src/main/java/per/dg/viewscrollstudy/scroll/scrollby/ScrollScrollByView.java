package per.dg.viewscrollstudy.scroll.scrollby;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

import per.dg.viewscrollstudy.scroll.CustomScrollView;

public class ScrollScrollByView extends CustomScrollView {

    public ScrollScrollByView(Context context) {
        super(context);
    }

    public ScrollScrollByView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollScrollByView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void scrollMethed(int offX, int offY) {
        scrollBy(offX, offY);
    }
}
