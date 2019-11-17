package com.example.weeklybudgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);

        TextView textView = (TextView) findViewById(R.id.testText);
        textView.setText("Your budget for this week:");

        TextView SavingsView = (TextView) findViewById(R.id.savingsText);
        SavingsView.setText("Savings: " + "$"+CategoryScreen.SavingsBudget);

        TextView BillsView = (TextView) findViewById(R.id.billsText);
        BillsView.setText("Bills: " + "$"+CategoryScreen.BillsBudget);

        TextView GasView = (TextView) findViewById(R.id.gasText);
        GasView.setText("Gas/Transportation: " + "$"+CategoryScreen.GasBudget);

        TextView EatingView = (TextView) findViewById(R.id.eatingText);
        EatingView.setText("Eating Out: " + "$"+CategoryScreen.EatingBudget);

        TextView GroceryView = (TextView) findViewById(R.id.groceriesText);
        GroceryView.setText("Groceries: " + "$"+CategoryScreen.GroceriesBudget);

        TextView MiscView = (TextView) findViewById(R.id.Misc);
        MiscView.setText("Other: "+"$"+CategoryScreen.MiscBudget);
    }
}
