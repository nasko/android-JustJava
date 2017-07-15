package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.os.Build.VERSION_CODES.N;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private Integer quantity = 0;
    private Integer unitPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity();
        displayPrice();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice();
    }

    public void increaseQuantity(View view) {
        quantity++;
        displayQuantity();
    }

    public void decreaseQuantity(View view) {
        if(quantity > 0) {
            quantity--;
        } else {
            Toast myToast = Toast.makeText(this, "Quantity cannot be a negative number.", Toast.LENGTH_SHORT);
            myToast.show();
        }
        displayQuantity();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(quantity * unitPrice));
    }
}