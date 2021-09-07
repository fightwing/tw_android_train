package com.thoughtworks.androidtrain;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.thoughtworks.androidtrain.fragment.MyFragmentActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_linearlayout);
    findViewById(R.id.btn_constraint_layout).setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, ConstraintActivity.class);
      startActivity(intent);
    });
    findViewById(R.id.btn_login).setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, LoginActivity.class);
      startActivity(intent);
    });
    findViewById(R.id.btn_pick_contact).setOnClickListener(v -> {
      selectContact();
    });
    findViewById(R.id.btn_fragment).setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
      startActivity(intent);
    });

  }

  static final int REQUEST_SELECT_PHONE_NUMBER = 1;

  public void selectContact() {
    // Start an activity for the user to pick a phone number from contacts
    Intent intent = new Intent(Intent.ACTION_PICK);
    intent.setType(CommonDataKinds.Phone.CONTENT_TYPE);
    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
      // Get the URI and query the content provider for the phone number
      Uri contactUri = data.getData();
      String[] projection = new String[]{Phone.NUMBER, Phone.DISPLAY_NAME};
      Cursor cursor = getContentResolver().query(contactUri, projection,
          null, null, null);
      // If the cursor returned is valid, get the phone number
      if (cursor != null && cursor.moveToFirst()) {
        int numberIndex = cursor.getColumnIndex(Phone.NUMBER);
        int nameIndex = cursor.getColumnIndex(Phone.DISPLAY_NAME);
        String number = cursor.getString(numberIndex);
        String name = cursor.getString(nameIndex);
        // Do something with the phone number
        //...
        Toast.makeText(this, name + ":" + number, Toast.LENGTH_LONG).show();
      }
    }
  }
}