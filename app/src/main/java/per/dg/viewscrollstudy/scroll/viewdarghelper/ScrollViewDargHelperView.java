package per.dg.viewscrollstudy.scroll.viewdarghelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class ScrollViewDargHelperView extends FrameLayout {
    public ScrollViewDargHelperView(@NonNull Context context) {
        this(context, null);
    }

    public ScrollViewDargHelperView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollViewDargHelperView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mViewDragHelper = ViewDragHelper.create(this, callback);
    }

    @Override
    public void computeScroll() {
        if(mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    View mMenuView;
    View mMainView;

    ViewDragHelper mViewDragHelper;

    int mWidth;

    ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        /**
         * 开始检测触摸事件
         * @param child
         * @param pointerId
         * @return
         */
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return mMainView == child;
        }

        /**
         * 处理水平滑动
         * @param child
         * @param left
         * @param dx
         * @return
         */
        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            return left;
        }

        /**
         * 处理垂直滑动
         * @param child
         * @param top
         * @param dy
         * @return
         */
        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            return 0;
        }

        /**
         * 拖动结束后调用
         * @param releasedChild
         * @param xvel
         * @param yvel
         */
        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mMainView.getLeft() < 500){
                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);
                ViewCompat.postInvalidateOnAnimation(ScrollViewDargHelperView.this);
            }else {
                mViewDragHelper.smoothSlideViewTo(mMainView, 300, 0);
                ViewCompat.postInvalidateOnAnimation(ScrollViewDargHelperView.this);
            }
        }

        /**
         * 用户触摸到view后回调
         * @param capturedChild
         * @param activePointerId
         */
        @Override
        public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        /**
         * 拖拽状态改变时回调
         * @param state
         */
        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        /**
         * 位置改变时回调
         * @param changedView
         * @param left
         * @param top
         * @param dx
         * @param dy
         */
        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }
    };

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }
}
