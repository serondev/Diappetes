// Generated by view binder compiler. Do not edit!
package com.serkanonder.diappetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import com.serkanonder.diappetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView alreadyHaveAnAccount;

  @NonNull
  public final Button btnRegister;

  @NonNull
  public final EditText etRegisterEmail;

  @NonNull
  public final EditText etRegisterPassword;

  @NonNull
  public final FrameLayout flHeaderImage;

  @NonNull
  public final TextInputLayout tilRegisterEmail;

  @NonNull
  public final TextInputLayout tilRegisterPassword;

  @NonNull
  public final TextView tvRegister;

  @NonNull
  public final TextView tvTitle;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView alreadyHaveAnAccount, @NonNull Button btnRegister,
      @NonNull EditText etRegisterEmail, @NonNull EditText etRegisterPassword,
      @NonNull FrameLayout flHeaderImage, @NonNull TextInputLayout tilRegisterEmail,
      @NonNull TextInputLayout tilRegisterPassword, @NonNull TextView tvRegister,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.alreadyHaveAnAccount = alreadyHaveAnAccount;
    this.btnRegister = btnRegister;
    this.etRegisterEmail = etRegisterEmail;
    this.etRegisterPassword = etRegisterPassword;
    this.flHeaderImage = flHeaderImage;
    this.tilRegisterEmail = tilRegisterEmail;
    this.tilRegisterPassword = tilRegisterPassword;
    this.tvRegister = tvRegister;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.already_have_an_account;
      TextView alreadyHaveAnAccount = ViewBindings.findChildViewById(rootView, id);
      if (alreadyHaveAnAccount == null) {
        break missingId;
      }

      id = R.id.btn_register;
      Button btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.et_register_email;
      EditText etRegisterEmail = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterEmail == null) {
        break missingId;
      }

      id = R.id.et_register_password;
      EditText etRegisterPassword = ViewBindings.findChildViewById(rootView, id);
      if (etRegisterPassword == null) {
        break missingId;
      }

      id = R.id.fl_header_image;
      FrameLayout flHeaderImage = ViewBindings.findChildViewById(rootView, id);
      if (flHeaderImage == null) {
        break missingId;
      }

      id = R.id.til_register_email;
      TextInputLayout tilRegisterEmail = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterEmail == null) {
        break missingId;
      }

      id = R.id.til_register_password;
      TextInputLayout tilRegisterPassword = ViewBindings.findChildViewById(rootView, id);
      if (tilRegisterPassword == null) {
        break missingId;
      }

      id = R.id.tv_register;
      TextView tvRegister = ViewBindings.findChildViewById(rootView, id);
      if (tvRegister == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, alreadyHaveAnAccount,
          btnRegister, etRegisterEmail, etRegisterPassword, flHeaderImage, tilRegisterEmail,
          tilRegisterPassword, tvRegister, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}