// Generated by view binder compiler. Do not edit!
package com.serkanonder.diappetes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.serkanonder.diappetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OnboardingItemContainerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageOnboarding;

  @NonNull
  public final TextView textDescription;

  @NonNull
  public final TextView textTitle;

  private OnboardingItemContainerBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imageOnboarding, @NonNull TextView textDescription,
      @NonNull TextView textTitle) {
    this.rootView = rootView;
    this.imageOnboarding = imageOnboarding;
    this.textDescription = textDescription;
    this.textTitle = textTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OnboardingItemContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OnboardingItemContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.onboarding_item_container, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OnboardingItemContainerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageOnboarding;
      ImageView imageOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (imageOnboarding == null) {
        break missingId;
      }

      id = R.id.textDescription;
      TextView textDescription = ViewBindings.findChildViewById(rootView, id);
      if (textDescription == null) {
        break missingId;
      }

      id = R.id.textTitle;
      TextView textTitle = ViewBindings.findChildViewById(rootView, id);
      if (textTitle == null) {
        break missingId;
      }

      return new OnboardingItemContainerBinding((LinearLayout) rootView, imageOnboarding,
          textDescription, textTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
