package com.example.weeklybudgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CategoryScreen extends AppCompatActivity {
    static String SavingsBudget, BillsBudget, GasBudget, EatingBudget, GroceriesBudget,MiscBudget;
    static Float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);
    }

    public void sendInfo(View view) {
        Intent intent = new Intent(this, DisplayScreen.class);

        EditText etSavings = (EditText) findViewById(R.id.SavingsInput);
        String Savings = etSavings.getText().toString();
        SavingsBudget = calculation(Savings);

        EditText etBills = (EditText) findViewById(R.id.BillsInput);
        String Bills = etBills.getText().toString();
        BillsBudget = calculation(Bills);

        EditText etGas = (EditText) findViewById(R.id.GasInput);
        String Gas = etGas.getText().toString();
        GasBudget = calculation(Gas);

        EditText etEatingOut = (EditText) findViewById(R.id.EatingInput);
        String EatingOut = etEatingOut.getText().toString();
        EatingBudget = calculation(EatingOut);

        EditText etGroceries = (EditText) findViewById(R.id.GroceriesInput);
        String Groceries = etGroceries.getText().toString();
        GroceriesBudget = calculation(Groceries);

        total = toFloat(Savings) + toFloat(Bills) + toFloat(Gas) + toFloat(EatingOut) + toFloat(Groceries);
        Float budgetAmount = toFloat(SavingsBudget) + toFloat(BillsBudget) + toFloat(GasBudget) + toFloat(EatingBudget) + toFloat(GroceriesBudget);

        Float misc = AmountScreen.amountTotal - budgetAmount;
        MiscBudget = Float.toString(misc);

        if (total == 100.0 || total < 100.0)
            startActivity(intent);
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(CategoryScreen.this);
            builder.setCancelable(true);
            builder.setTitle("Error");
            builder.setMessage("The percentages exceed 100%");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }

    private float toFloat(String category){
        Float newFloat =  Float.parseFloat(category);
        return newFloat;
    }

    private float CalculateBudget (float number, float amount){
        float percent = toDecimal(number);
        float budget = amount*percent;
        return budget;
    }

    private float toDecimal(float number) {
        float percentage = number/100;
        return percentage;
    }

    private String calculation(String category){
        Float newBudget = toFloat(category);
        Float CalculatedBudget = CalculateBudget(newBudget,AmountScreen.amountTotal);
        String newString = Float.toString(CalculatedBudget);
        return newString ;
    }
}
