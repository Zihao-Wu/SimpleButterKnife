package com.wzh.mybutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wzh.butterknife.ButterKnife;
import com.wzh.butterknife.annotation.BindView;

/**
 * 如果不想用注解,强烈建议在 BaseActivity和BaseFragment 中。加上
 * public <V extends View> V findView(@IdRes int id){} 省出强转操作
 * (参考Demo中 BaseActivity和BaseFragment)
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.text_view)
    private TextView mTextView;

    @BindView(R.id.button)
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //解释注解
        ButterKnife.bindView(this);

        initView();
    }

    private void initView() {
        View root=findViewById(R.id.layout_root);

        //findView
        ListView listView=ButterKnife.findView(root,R.id.list_view);
        EditText editText=findView(R.id.edit_text);

        mTextView.setText("TextView from ButterKnife.bindView(Activity activity)");

        mButton.setText("New Button");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"listView from ButterKnife.findView(View parent, @IdRes int id)",Toast.LENGTH_LONG).show();
            }
        });
        editText.setText("from findView(@IdRes int id)");
    }
}
