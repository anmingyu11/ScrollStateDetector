package com.amy.scrolldetectorexample.sub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.amy.scrolldetectorexample.R;

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("ScrollView");
        setContentView(R.layout.web_view_layout);
    }

}
