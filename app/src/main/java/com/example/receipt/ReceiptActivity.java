package com.example.receipt;

import android.content.Intent;  // Add this import statement
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView emailTextView;
    private TextView totalPriceTextView;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        sendButton = findViewById(R.id.sendButton);

        // Retrieve data from Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String totalPrice = getIntent().getStringExtra("totalPrice");

        // Display data
        nameTextView.setText("Name: " + name);
        emailTextView.setText("Email: " + email);
        totalPriceTextView.setText("Total Price: $" + totalPrice);

        // Set click listener for the send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(name, email, totalPrice);
            }
        });
    }

    private void sendEmail(String name, String email, String totalPrice) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");

        String subject = "Receipt Information";
        String body = "Name: " + name + "\nEmail: " + email + "\nTotal Price: $" + totalPrice;

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        // Ensure there's an app that can handle the email intent
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }
}
