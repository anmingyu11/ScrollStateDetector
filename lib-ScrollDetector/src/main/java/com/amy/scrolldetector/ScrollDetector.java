package com.amy.scrolldetector;

import android.support.v7.widget.RecyclerView;

public final class ScrollDetector {

    public static final int SCROLL_IDLE = 0;
    public static final int SCROLL_DRAGGING = 1;
    public static final int SCROLL_SETTLING = 2;

    public static final void detectScroll(final RecyclerView recyclerView, final OnScrollDetectorListener onScrollDetectorListener) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            boolean lastItemPosition = false;
            boolean lastItemBottom = false;
            boolean firstItemPosition = false;
            boolean firstItemTop = false;

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                onScrollDetectorListener.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                onScrollDetectorListener.onScrolled(recyclerView, dx, dy);

                int childCount = recyclerView.getChildCount();

                if (isToTop(childCount)) {
                    onScrollDetectorListener.onScrollToTop();
                } else if (isToBottom(childCount)) {
                    onScrollDetectorListener.onScrollToBottom();
                } else {
                    onScrollDetectorListener.onScrollInContent();
                }
            }

            private boolean isToBottom(int childCount) {
                lastItemPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(childCount - 1))
                        == recyclerView.getAdapter().getItemCount() - 1;
                lastItemBottom = recyclerView.getChildAt(childCount - 1).getBottom() == recyclerView.getHeight();
                return lastItemBottom && lastItemPosition;
            }

            private boolean isToTop(int childCount) {
                firstItemPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) == 0;
                firstItemTop = recyclerView.getChildAt(0).getTop() == 0;
                return firstItemTop && firstItemPosition;
            }

        });
    }
}
