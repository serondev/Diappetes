// Generated by view binder compiler. Do not edit!
package com.serkanonder.diappetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.serkanonder.diappetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRecevingDataBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnClear;

  @NonNull
  public final Button btnGetData;

  @NonNull
  public final TextView tvReceiveddata;

  private ActivityRecevingDataBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnClear,
      @NonNull Button btnGetData, @NonNull TextView tvReceiveddata) {
    this.rootView = rootView;
    this.btnClear = btnClear;
    this.btnGetData = btnGetData;
    this.tvReceiveddata = tvReceiveddata;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRecevingDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRecevingDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_receving_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRecevingDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnClear;
      Button btnClear = ViewBindings.findChildViewById(rootView, id);
      if (btnClear == null) {
        break missingId;
      }

      id = R.id.btnGetData;
      Button btnGetData = ViewBindings.findChildViewById(rootView, id);
      if (btnGetData == null) {
        break missingId;
      }

      id = R.id.tvReceiveddata;
      TextView tvReceiveddata = ViewBindings.findChildViewById(rootView, id);
      if (tvReceiveddata == null) {
        break missingId;
      }

      return new ActivityRecevingDataBinding((ConstraintLayout) rootView, btnClear, btnGetData,
          tvReceiveddata);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
