package com.amy.scrolldetectorexample.sub;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.amy.scrolldetectorexample.R;

public class AbsListViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.abs_list_view_layout);
    }
}
