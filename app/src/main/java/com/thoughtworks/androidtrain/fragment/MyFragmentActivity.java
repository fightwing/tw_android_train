package com.thoughtworks.androidtrain.fragment;

import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.thoughtworks.androidtrain.R;

public class MyFragmentActivity extends AppCompatActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.my_fragment_layout);
    initUI();
  }

  private void initUI() {
    Button btnAndroid = findViewById(R.id.btn_android);
    btnAndroid.setOnClickListener(v -> replaceFragmentAndAddToBackStack(getSupportFragmentManager(),
        new ContentAndroidFragment()
    ));

    Button btnJava = findViewById(R.id.btn_java);
    btnJava.setOnClickListener(v -> replaceFragmentAndAddToBackStack(getSupportFragmentManager(),
        new ContentJavaFragment()));

    replaceFragmentAndAddToBackStack(getSupportFragmentManager(), new ContentAndroidFragment());
  }

  private static void replaceFragmentAndAddToBackStack(@NonNull FragmentManager fragmentManager,
      @NonNull Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.content, fragment);
    transaction.addToBackStack(null);
    transaction.commitAllowingStateLoss();
  }
}
