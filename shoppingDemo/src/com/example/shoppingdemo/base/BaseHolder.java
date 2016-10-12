package com.example.shoppingdemo.base;

import android.view.View;

/**
 * Created by hjz on 2016/9/26.
 */
public abstract class BaseHolder<T> {

    private View mRootView;

    private T data;

    public BaseHolder(){
        mRootView = initView();

        //3设置tag
        mRootView.setTag(this);
    }

    /**
     * 1.初始化item的布局  让子类实现
     * 2.findViewById
     */
    public abstract View initView();

    /**
     * 获取item的布局对象
     * @return
     */
    public View getRootView(){
        return mRootView;
    }

    //获取数据
    public T getData(){
        return data;
    }

    /**
     * 设置数据  并自动刷新界面
     * @param data
     */
    public void setData(T data){
        this.data=data;
        //一旦有了数据  就马上刷新
        refreshView(data);
    }

    /**
     * 4.刷新界面  交给子类实现
     */
    public abstract void refreshView(T data);

}

