package per.dg.viewscrollstudy.scroll.marginlayoutparams;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import per.dg.viewscrollstudy.scroll.CustomScrollView;

/**
 * 注意事项：
 * 1、必须提前设置相对其他 view 的定位，否则设置将不起作用
 * 2、因为是控制父布局进行重新显示子控件，所以其他 view 也会重新绘制
 * 3、设置的滑动距离不能为负数，否则不起作用
 */

public class ScrollMarginLayoutParamsView extends CustomScrollView {

    int oldX;
    int oldY;

    public ScrollMarginLayoutParamsView(Context context) {
        super(context);
    }

    public ScrollMarginLayoutParamsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollMarginLayoutParamsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
//                ViewGroup.MarginLayoutParams mMarginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                mMarginLayoutParams.topMargin += offY;
//                mMarginLayoutParams.leftMargin += offX;
//                setLayoutParams(mMarginLayoutParams);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }

    @Override
    public void scrollMethed(int offX, int offY) {
        ViewGroup.MarginLayoutParams mMarginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        mMarginLayoutParams.topMargin += offY;
        mMarginLayoutParams.leftMargin += offX;
        setLayoutParams(mMarginLayoutParams);
    }
}
