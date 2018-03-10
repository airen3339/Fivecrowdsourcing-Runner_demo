package com.example.wun.testservlet.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
        import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public abstract class BaseFragment extends Fragment {

    protected Context mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = getContext();//上下文。
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();//初始化布局。
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();//初始化数据。
    }

    protected abstract void loadData();

    protected abstract View initView();

}