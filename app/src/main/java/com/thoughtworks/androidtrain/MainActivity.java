package com.thoughtworks.androidtrain;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_linearlayout);
    findViewById(R.id.btn_constraint_layout).setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, ConstraintActivity.class);
      startActivity(intent);
    });
  }
}