package com.jiashizhan.myfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class ProgressDialogFragment2 extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE); //消除Title区域
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //将背景变为透明
        setCancelable(true);  //点击外部不可取消false
        View root = inflater.inflate(R.layout.fragment_progress_dialog, container);
        return root;
    }

    public static ProgressDialogFragment2 newInstance2() {
        return new ProgressDialogFragment2();
    }
}
