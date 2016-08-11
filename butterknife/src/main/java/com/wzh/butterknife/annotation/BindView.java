package com.wzh.butterknife.annotation;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wzh on 2016/8/11.
 * 给 成员变量view 指定 BindView注解
 *
   @BindView(R.id.text_view)
   private TextView mTextView;

 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface BindView {
    int DEFAULT_ID = -1;

    @IdRes int value() default DEFAULT_ID;
}
