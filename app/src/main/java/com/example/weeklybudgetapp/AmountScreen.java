package com.example.weeklybudgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AmountScreen extends AppCompatActivity {

    static Float amountTotal;
    static String Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_screen);

    }
    public void sendMessage(View view){
        /* does something with continue button */
        Intent intent = new Intent(this, CategoryScreen.class);
        EditText et = (EditText) findViewById(R.id.AmountInput);
        Amount = et.getText().toString();
        amountTotal = Float.parseFloat(Amount);
        intent.putExtra("AMOUNTTOTAL", amountTotal);
        startActivity(intent);
    }

}
