package com.jiashizhan.myfragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class Fragment1 extends Fragment {
    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;
    private String string = "000";
    private TextView view;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);  //获取参数
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);
        view = root.findViewById(R.id.text1);
        view.setText(mParam);
        return root;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    Log.e("string", string);
                    break;
            }
        }
    };

    public static Fragment1 newInstance(String str) {
        Fragment1 fragment = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, str);
        fragment.setArguments(bundle);   //设置参数
        return fragment;
    }

    public void setString(String str) {
        this.string = str;
        Log.e("str", str);
        Message message = Message.obtain();
        message.what = 0;
        handler.sendMessage(message);
    }
}
