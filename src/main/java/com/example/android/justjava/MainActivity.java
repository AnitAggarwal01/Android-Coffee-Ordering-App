package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

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
    public void increaseQuantity(View view){
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        final CharSequence text = quantityTextView.getText();
        final int newQuantity = Integer.parseInt( text.toString() ) + 1;
        quantityTextView.setText("" + newQuantity );
    }
    public void decreaseQuantity(View view){
        TextView quantityTextView =  findViewById(R.id.quantityTextView);
        final CharSequence text = quantityTextView.getText();
        int newQuantity = Integer.parseInt( text.toString() ) ;
        if(newQuantity >0)
                newQuantity--;
        quantityTextView.setText("" + newQuantity );
    }
    public void submitOrder(View view) {
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        TextView priceTextView =  findViewById(R.id.priceTextView);
        final CharSequence text = quantityTextView.getText();
        final int quantity = Integer.parseInt( text.toString() ) ;
        if(quantity == 0)
            return;
        CheckBox WhippedCreamCheckBox = findViewById(R.id.whippedCreamCheckbox);
        CheckBox ChocolateCheckBox = findViewById(R.id.chocolateCheckbox);
        int price  = 2;
        if(WhippedCreamCheckBox.isChecked())
            price++;
        if(ChocolateCheckBox.isChecked())
            price += 2;
        priceTextView.setText("$" + quantity*price );
        TextView orderSummaryHeadingTextView = findViewById(R.id.orderSummaryHeading);
        TextView orderSummaryTextView = findViewById(R.id.orderSummary);
        orderSummaryHeadingTextView.setVisibility(View.VISIBLE);
        orderSummaryTextView.setText(orderSummary());
        if(WhippedCreamCheckBox.isChecked())
            WhippedCreamCheckBox.toggle();
        if(ChocolateCheckBox.isChecked()){
            ChocolateCheckBox.toggle();
        }
    }
    public void reset(View view) {
        TextView quantityTextView =  findViewById(R.id.quantityTextView);
        TextView priceTextView =  findViewById(R.id.priceTextView);
        TextView orderSummaryTextView = findViewById(R.id.orderSummary);
        TextView orderSummaryHeadingTextView = findViewById(R.id.orderSummaryHeading);
        CheckBox WhippedCreamCheckBox = findViewById(R.id.whippedCreamCheckbox);
        CheckBox ChocolateCheckBox = findViewById(R.id.chocolateCheckbox);
        orderSummaryHeadingTextView.setVisibility(View.INVISIBLE);
        if(WhippedCreamCheckBox.isChecked())
            WhippedCreamCheckBox.toggle();
        if(ChocolateCheckBox.isChecked())
            ChocolateCheckBox.toggle();
        orderSummaryTextView.setText("");
        quantityTextView.setText(""+ 0);
        priceTextView.setText("$"+ 0);
    }
    public String orderSummary(){
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        CheckBox WhippedCreamCheckbox = findViewById(R.id.whippedCreamCheckbox);
        CheckBox ChocolateCheckbox = findViewById(R.id.chocolateCheckbox);

        String summary = " Name : Anit Aggarwal";
        summary += "\n Quantity : " + quantityTextView.getText().toString();
        if(WhippedCreamCheckbox.isChecked() || ChocolateCheckbox.isChecked()){
            summary += "\n With toppings :";
            summary += WhippedCreamCheckbox.isChecked() ? "Whipped Cream" : "";
            summary += WhippedCreamCheckbox.isChecked() && ChocolateCheckbox.isChecked() ? " and " : "";
            summary += ChocolateCheckbox.isChecked() ? "Chocolate Syrup " : "";
        }
        summary += "\n You owe me : " + priceTextView.getText().toString();
        return summary;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
}