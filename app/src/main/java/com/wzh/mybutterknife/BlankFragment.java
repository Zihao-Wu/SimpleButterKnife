package com.wzh.mybutterknife;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wzh.butterknife.ButterKnife;
import com.wzh.butterknife.annotation.BindView;

public class BlankFragment extends Fragment {

    @BindView(R.id.custom)
    private CustomView mCustomView;

    @BindView(R.id.text_view)
    TextView mTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           /* mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bindView(this);
        initView();
    }

    private void initView() {
        mCustomView.setBackgroundColor(Color.YELLOW);

        mTextView.setText("from BlankFragment, call ButterKnife.bindView(Fragment fragment)");
    }


}
