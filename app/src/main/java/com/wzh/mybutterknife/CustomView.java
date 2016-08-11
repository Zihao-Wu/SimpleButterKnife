package com.wzh.mybutterknife;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.wzh.butterknife.ButterKnife;
import com.wzh.butterknife.annotation.BindView;

/**
 * Created by wzh on 2016/8/11.
 */
public class CustomView extends LinearLayout{

    @BindView(R.id.button)
    private Button mButton;

    @BindView(R.id.checkbox) private CheckBox mCheckBox;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.view_custom,null);
        addView(view);

        ButterKnife.bindView(this);

        mButton.setText("child Button");
        mCheckBox.setText("ButterKnife.bindView(View customView)");

    }
}
