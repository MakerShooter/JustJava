package com.example.user.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    int oneCoffePrice = 5;
    private TextView priceTextView;
    private TextView quantityTextView;
    private CheckBox whippedCheckBox;
    private CheckBox chocolateCheckBox;
    boolean isExtra;
    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        whippedCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped);
        chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(oneCoffePrice));
        quantityTextView.setText(" " + quantity);
        editName = (EditText) findViewById(R.id.edit_name);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

Log.v("MainActivity","quantity "+ quantity);
        display(quantity);
        displayPrice(quantity);

    }

    /**
     * This method increment the number of coffee
     */

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }
    /**
     * This method increment the number of coffee
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        display(quantity);
    }



    private void display(int number) {

        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price value on the screen.
     */
    private void displayPrice(int number) {
        number = number * oneCoffePrice;
        String message = NumberFormat.getCurrencyInstance().format(number) + "\n" + "price for " + quantity + " coffees";
        if (whippedCheckBox.isChecked()){
            message +="\n" +"With Whipped Cream";
            isExtra = true;
        } else {
            message +="\n" +"Without Whipped Cream";
            isExtra = false;
        }
        if (chocolateCheckBox.isChecked()){
            message +="\n"+ "With Chocolate";
            isExtra = true;
        }
        else {
            message +="\n" +"Without Chocolate";
            isExtra = false;
        }


       // Log.v("MainActivity", "is checked" + isExtra);
        String name = editName.getText().toString();
        message+= name;
        priceTextView.setText(message);


    }

}
