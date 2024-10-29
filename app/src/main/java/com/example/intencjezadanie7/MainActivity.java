package com.example.intencjezadanie7;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView receivedDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedDataTextView = findViewById(R.id.receivedDataTextView);

        handleIncomingIntent();
    }

    private void handleIncomingIntent() {
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String receivedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (receivedText != null) {
                    receivedDataTextView.setText("Otrzymany tekst: " + receivedText);
                }
            } else if ("application/vnd.android.intent.extra.INT".equals(type)) {
                int receivedNumber = intent.getIntExtra("extra_number", 0);
                receivedDataTextView.setText("Otrzymana liczba: " + receivedNumber);
            }
        }
    }
}