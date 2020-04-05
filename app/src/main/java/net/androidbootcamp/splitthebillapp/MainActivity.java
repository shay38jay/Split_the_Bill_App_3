package net.androidbootcamp.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double value;
    int itemBill;
    double itemTax = 0.18;
    int numberOfPeople;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText people = findViewById(R.id.txtPeople);
        final EditText bill = findViewById(R.id.txtRequest);
        final Spinner group = findViewById(R.id.txtGroup);
        Button billsplit = findViewById(R.id.btnSplit);
        Button cost = findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = findViewById(R.id.txtResult);

            @Override
            public void onClick(View v) {
                numberOfPeople = Integer.parseInt(people.getText().toString());
                itemBill = Integer.parseInt(bill.getText().toString());
                value = itemBill * itemTax / numberOfPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Total Bill Split each is " + currency.format(value));
                startActivity(new Intent(MainActivity.this, BillSplit.class));
            }
        });
    }
}























