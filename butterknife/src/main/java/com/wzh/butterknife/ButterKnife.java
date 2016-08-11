package com.wzh.butterknife;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wzh.butterknife.annotation.BindView;

import java.lang.reflect.Field;

/**
 * Created by wzh on 2016/8/11.
 * 解释 BindView 注解的类
 */
public class ButterKnife {

    /**
     * 在 setContentView(R.layout.activity_main); 之后调用
     * @param activity 含有BindView 注解的activity
     */
    public static void bindView(@NonNull Activity activity){
        View rootView=activity.findViewById(android.R.id.content);
        bindView(activity,rootView);
    }

    /**
     * 在 onViewCreated(view , savedInstanceState){
     *     ButterKnife.bindView(this);
     * } 之中调用最佳
     * @param fragment 含有BindView 注解的fragment
     */
    public static void bindView(@NonNull Fragment fragment){
        View rootView=fragment.getView();
        if(rootView==null){
            throw new NullPointerException(fragment+" rootView is Null!" +
                    " please call bindView(fragment) in onViewCreated(xxx)");
        }
        bindView(fragment,rootView);
    }

    /**
     * 建议 在 addView(view) 之后调用
     * @param customView 含有BindView 注解的自定义view等
     */
    public static void bindView(@NonNull View customView){
        bindView(customView,customView);
    }

    /**
     * 对 含有BindView 注解的成员变量进行findView操作，此为关键方法。
     * @param target 注解所处的对象，可为任意对象
     * @param parent xml 所构造的根view
     */
    public static void bindView(@NonNull Object target,@NonNull View parent){
        Field[] fields=target.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(BindView.class)){
                BindView bindView=field.getAnnotation(BindView.class);
                int id=bindView.value();
                if(id != BindView.DEFAULT_ID){
                    field.setAccessible(true);
                    try {
                        field.set(target,findView(parent,id));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * ListView listView=ButterKnife.findView(root,R.id.list_view);
     * @param parent 此view 的父级view，一般为rootView
     * @param id id ,R.id.xxx
     * @param <V> 返回指定view
     * @return
     */
    public static <V extends View> V findView(@NonNull View parent, @IdRes int id){
        return (V) parent.findViewById(id);
    }
}
