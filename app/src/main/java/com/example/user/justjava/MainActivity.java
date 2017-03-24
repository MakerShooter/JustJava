package com.example.user.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int numberOfCoffee = 8;
        display();
        displayPrice();
    }
    public void increment() {
        int quantity = 3;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int num = Integer.valueOf(quantityTextView.getText().toString());
        quantityTextView.setText(quantity);
    }
    public void decrement() {
        int quantity = 1;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
      //  int num = Integer.valueOf(quantityTextView.getText().toString());
        quantityTextView.setText(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int num = Integer.valueOf(quantityTextView.getText().toString());
        quantityTextView.setText((num+1));
    }

    private void displayPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
       String str = priceTextView.getText().toString();
        int iend =  str.indexOf(",");
        String subString = "0";
        if (iend != -1) {
            subString = str.substring(0, iend);
        }
        int num = Integer.valueOf(subString);

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(num+1));
    }

}
