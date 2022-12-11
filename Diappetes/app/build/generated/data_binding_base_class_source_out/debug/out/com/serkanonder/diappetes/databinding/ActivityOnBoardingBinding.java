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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.serkanonder.diappetes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOnBoardingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton buttonGetStarted;

  @NonNull
  public final ImageView imageNext;

  @NonNull
  public final LinearLayout indicatorsContainer;

  @NonNull
  public final ViewPager2 onBoardingViewPager;

  @NonNull
  public final TextView textSkip;

  @NonNull
  public final View viewCenterOfNext;

  private ActivityOnBoardingBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton buttonGetStarted, @NonNull ImageView imageNext,
      @NonNull LinearLayout indicatorsContainer, @NonNull ViewPager2 onBoardingViewPager,
      @NonNull TextView textSkip, @NonNull View viewCenterOfNext) {
    this.rootView = rootView;
    this.buttonGetStarted = buttonGetStarted;
    this.imageNext = imageNext;
    this.indicatorsContainer = indicatorsContainer;
    this.onBoardingViewPager = onBoardingViewPager;
    this.textSkip = textSkip;
    this.viewCenterOfNext = viewCenterOfNext;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOnBoardingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOnBoardingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_on_boarding, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOnBoardingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonGetStarted;
      MaterialButton buttonGetStarted = ViewBindings.findChildViewById(rootView, id);
      if (buttonGetStarted == null) {
        break missingId;
      }

      id = R.id.imageNext;
      ImageView imageNext = ViewBindings.findChildViewById(rootView, id);
      if (imageNext == null) {
        break missingId;
      }

      id = R.id.indicatorsContainer;
      LinearLayout indicatorsContainer = ViewBindings.findChildViewById(rootView, id);
      if (indicatorsContainer == null) {
        break missingId;
      }

      id = R.id.onBoardingViewPager;
      ViewPager2 onBoardingViewPager = ViewBindings.findChildViewById(rootView, id);
      if (onBoardingViewPager == null) {
        break missingId;
      }

      id = R.id.textSkip;
      TextView textSkip = ViewBindings.findChildViewById(rootView, id);
      if (textSkip == null) {
        break missingId;
      }

      id = R.id.viewCenterOfNext;
      View viewCenterOfNext = ViewBindings.findChildViewById(rootView, id);
      if (viewCenterOfNext == null) {
        break missingId;
      }

      return new ActivityOnBoardingBinding((ConstraintLayout) rootView, buttonGetStarted, imageNext,
          indicatorsContainer, onBoardingViewPager, textSkip, viewCenterOfNext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
