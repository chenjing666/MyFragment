package com.jiashizhan.myfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class ProgressDialogFragment extends DialogFragment {
    private static final String KEY_TITLE = "key_title";
    private static final String KEY_MESSAGE = "key_message";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 拿到数据
        String title = getArguments().getString(KEY_TITLE);
        String message = getArguments().getString(KEY_MESSAGE);
        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }

    public static ProgressDialogFragment newInstance(String title, String message) {
        ProgressDialogFragment dialogFragment = new ProgressDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        bundle.putString(KEY_MESSAGE, message);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }
}
