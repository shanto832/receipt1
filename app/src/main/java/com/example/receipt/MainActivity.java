package com.example.receipt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private CheckBox chocolateCheckBox;
    private CheckBox chipsCheckBox;
    private NumberPicker quantityPicker;
    private TextView totalPriceTextView;
    private Button submitButton;
    private Button proceedButton;
    private PurchaseViewModel purchaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        chocolateCheckBox = findViewById(R.id.chocolateCheckBox);
        chipsCheckBox = findViewById(R.id.chipsCheckBox);
        quantityPicker = findViewById(R.id.quantityPicker);
        totalPriceTextView = findViewById(R.id.totalPriceTextView);
        submitButton = findViewById(R.id.submitButton);
        proceedButton = findViewById(R.id.proceedButton);

        purchaseViewModel = new ViewModelProvider(this).get(PurchaseViewModel.class);

        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(10); // Set max value as per your requirement

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChocolateSelected = chocolateCheckBox.isChecked();
                boolean isChipsSelected = chipsCheckBox.isChecked();
                int quantity = quantityPicker.getValue();

                double totalPrice = purchaseViewModel.calculateTotalPrice(isChocolateSelected, isChipsSelected, quantity);
                totalPriceTextView.setText("Total Price: $" + totalPrice);
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String totalPrice = totalPriceTextView.getText().toString().replace("Total Price: $", "");

                // Intent to start ReceiptActivity and pass data
                Intent intent = new Intent(MainActivity.this, ReceiptActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });
    }
}
