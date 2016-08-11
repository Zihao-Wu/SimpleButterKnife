package com.wzh.mybutterknife;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by wzh on 2016/8/11.
 */
public class BaseFragment extends Fragment{

    public <V extends View> V findView(@IdRes int id){
        return (V) getView().findViewById(id);
    }
}
