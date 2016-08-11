package com.wzh.mybutterknife;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    public <V extends View> V findView(@IdRes int id){
        return (V) findViewById(id);
    }
}
