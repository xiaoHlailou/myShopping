package com.example.shoppingdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


public abstract class BaseFragment extends Fragment {

    //标题可以快速控制

    //不能加private
    ImageButton left;
    ImageButton right;
    TextView title;

    protected View rootView;
    protected Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    public ImageButton getRight() {
        return right;
    }

    public ImageButton getLeft() {
        return left;
    }

    public TextView getTitle() {
        return title;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    protected int getScreenWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        return display.getWidth();
    }

    protected void setTitle(String titleStr) {
        if (title != null) {
            title.setText(titleStr);
        }
    }

    protected void showLeft(int resId) {
        if (left != null) {
            left.setImageResource(resId);
            left.setVisibility(View.VISIBLE);
        }
    }

    protected void showRight(int resId) {
        if (right != null) {
            right.setImageResource(resId);
            right.setVisibility(View.VISIBLE);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        //必须在setcontentview方法之后调用
        //不是activity  就以下方法做
//        ViewUtils.inject(this, rootView);//使注解生效
        if (rootView == null) {
            rootView = View.inflate(mContext, getLayoutId(), null);


            initView();//初始化界面   由子类实现
        } else {
            //remove parent
            ViewGroup parent= (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }

        getData();//获取服务端数据   由子类实现

        updateViewData();

        return rootView;

    }

    protected void httpGetRequest(String url, RequestCallBack requestCallBack) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, requestCallBack);
    }

    protected void httpPostRequest(String url, RequestParams form, RequestCallBack
            requestCallBack) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, url, form, requestCallBack);
    }

    public abstract int getLayoutId();

    public abstract void getData();

    public abstract void initView();

    public abstract void updateViewData();


}
