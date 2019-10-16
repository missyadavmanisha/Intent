package net.leanin.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("data");
        textView.setText(name);


    }
}
