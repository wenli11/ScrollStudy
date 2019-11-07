package per.dg.viewscrollstudy.scroll.offset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

import per.dg.viewscrollstudy.scroll.CustomScrollView;

public class ScrollOffSetView extends CustomScrollView {

    int oldX;
    int oldY;

    public ScrollOffSetView(Context context) {
        super(context);
    }

    public ScrollOffSetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollOffSetView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    /**
//     * 获取坐标时使用 Android 坐标系（getRawX），如果使用视图坐标系（getX）会造成 view 的移动与手指的移动产生差异，因为滑动的距离可能超过视图坐标的边界
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int nowX = (int) event.getRawX();
//        int nowY = (int) event.getRawY();
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                oldX = (int) event.getRawX();
//                oldY = (int) event.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offX = nowX - oldX;
//                int offY = nowY - oldY;
//                oldX = nowX;
//                oldY = nowY;
//                offsetLeftAndRight(offX);
//                offsetTopAndBottom(offY);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }

    @Override
    public void scrollMethed(int offX, int offY) {
        offsetLeftAndRight(offX);
        offsetTopAndBottom(offY);
    }

}
