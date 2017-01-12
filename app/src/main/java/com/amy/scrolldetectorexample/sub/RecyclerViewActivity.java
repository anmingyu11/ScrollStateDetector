package com.amy.scrolldetectorexample.sub;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amy.scrolldetector.OnScrollDetectorListener;
import com.amy.scrolldetector.ScrollDetector;
import com.amy.scrolldetectorexample.LogUtil;
import com.amy.scrolldetectorexample.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private Context mContext;

    private List<String> mStrings = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.recycler_view_layout);
        setTitle("RecyclerView");
        initRecyclerView();
    }

    private void initRecyclerView() {
        for (int i = 0; i < 20; i++) {
            mStrings.add("item  " + i);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ScrollDetector.detectScroll(mRecyclerView, new OnScrollDetectorListener<RecyclerView>() {
            @Override
            public void onScrollStateChanged(RecyclerView view, int newState) {
                LogUtil.d("onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView view, int dx, int dy) {
                LogUtil.d("onScrolled dy : " + dy + " dx : " + dx);
            }

            @Override
            public void onScrollToBottom() {
                LogUtil.d("onScrollToBottom");
            }

            @Override
            public void onScrollToTop() {
                LogUtil.d("onScrollToTop");
            }

            @Override
            public void onScrollInContent() {
                LogUtil.d("onScrollInContent");
            }

        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                holder.mTextView.setText(mStrings.get(position));
            }

            @Override
            public int getItemCount() {
                return mStrings.size();
            }

        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
