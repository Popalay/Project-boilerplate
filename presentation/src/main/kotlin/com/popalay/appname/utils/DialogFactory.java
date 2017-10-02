package com.popalay.appname.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.popalay.yocard.R;

public final class DialogFactory {

    public static Dialog createSimpleOkErrorDialog(Context context, String message) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context, R.style.DialogTheme)
                .setTitle(R.string.error)
                .setMessage(message)
                .setPositiveButton(R.string.action_ok, null);
        return alertDialog.create();
    }

    public static Dialog createSimpleInfoDialog(Context context, String message,
            @Nullable DialogInterface.OnDismissListener onDismiss) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context, R.style.DialogTheme)
                .setMessage(message)
                .setOnDismissListener(onDismiss)
                .setPositiveButton(R.string.action_ok, null);
        return alertDialog.create();
    }

    public static Dialog createSimpleOkCancelDialog(Context context, String message,
            @Nullable DialogInterface.OnClickListener positiveButtonClickListener,
            @Nullable DialogInterface.OnDismissListener onDismissListener) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context, R.style.DialogTheme)
                .setMessage(message)
                .setPositiveButton(R.string.action_ok, positiveButtonClickListener)
                .setOnDismissListener(onDismissListener)
                .setNegativeButton(R.string.cancel, null);
        return alertDialog.create();
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        final ProgressDialog progressDialog = new ProgressDialog(context, R.style.ProgressDialogTheme);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
