package com.thoughtworks.androidtrain;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;

public class LoginActivity extends AppCompatActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_activity);
    initUI();
  }

  private void initUI() {
    hideStatusBar();
    hideActionBar();
  }

  private void hideStatusBar() {
    if (VERSION.SDK_INT >= VERSION_CODES.R) {
      WindowInsetsController windowInsetsController = getWindow().getInsetsController();
      windowInsetsController.hide(WindowInsets.Type.statusBars());
    } else {
      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
  }

  private void hideActionBar() {
    ActionBar supportActionBar = getSupportActionBar();
    if (supportActionBar != null) {
      supportActionBar.hide();
    }
  }

}
