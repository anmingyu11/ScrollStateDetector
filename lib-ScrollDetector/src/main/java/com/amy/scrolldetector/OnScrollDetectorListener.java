package com.amy.scrolldetector;

import android.view.View;

public interface OnScrollDetectorListener<T extends View> {

    void onScrollStateChanged(T t, int newState);

    void onScrolled(T t, int dx, int dy);

    void onScrollToBottom();

    void onScrollToTop();

    void onScrollInContent();
}
