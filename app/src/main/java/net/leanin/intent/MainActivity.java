package net.leanin.intent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btn, callIntentButton, urlIntentButton, galleryIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
        btn = findViewById(R.id.btnClickMe);
        callIntentButton = findViewById(R.id.callIntent);
        urlIntentButton = findViewById(R.id.urlIntent);
        galleryIntent = findViewById(R.id.galleryIntent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("data", input.getText().toString());
                startActivity(intent);
            }
        });

        callIntentButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9999860841"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions

                    Toast.makeText(MainActivity.this, "Don't have permission", Toast.LENGTH_SHORT).show();
                     return;
                }
                else {
                    startActivity(intent);
                }
            }
        });

        urlIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = input.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        galleryIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setType("image/*");
               startActivity(intent);
            }
        });



    }
}
